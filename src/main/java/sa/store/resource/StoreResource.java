package sa.store.resource;

import sa.store.model.Store;
import sa.store.service.StoreService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/stores")
public class StoreResource {

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
        storeService.createStore(store);
        return Response.status(Response.Status.CREATED).build();
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
        storeService.deleteStore(code);
        return Response.status(Response.Status.OK).build();
    }

}
