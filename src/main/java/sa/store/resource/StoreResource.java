package sa.store.resource;

import sa.store.model.Store;
import sa.store.service.StoreService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.util.List;

@Path("/stores")
public class StoreResource {

    ResponseBuilder response;

    @Context
    UriInfo uriInfo;

    @EJB
    StoreService storeService;

    @GET
    public List<Store> getAllStores(@QueryParam("first") int first, @QueryParam("maxResult") int maxResult) {
        return storeService.getAllStores(first, maxResult);
    }

    @GET
    @Path("{code}")
    public Store getStoreByCode(@PathParam("code") int code) {
        return storeService.getStoreByCode(code);
    }

    @POST
    public Response createStore(Store store) {
        Store createdStore = storeService.createStore(store);
        response = Response.status(Response.Status.CREATED);
        response.entity(createdStore);
        return response.build();
    }

    @PUT
    @Path("{code}")
    public Response updateStore(@PathParam("code") int code, Store store) {
        storeService.updateStore(code, store);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("{code}")
    public Response deleteStore(@PathParam("code") int code) {
        int deletedStoreCode = storeService.deleteStore(code);
        response = Response.status(Response.Status.OK);
        response.entity(deletedStoreCode);
        return response.build();
    }

}
