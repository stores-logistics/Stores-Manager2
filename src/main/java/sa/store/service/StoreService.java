package sa.store.service;

import sa.store.model.Store;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class StoreService {

    @PersistenceContext
    EntityManager entityManager;

    public List<Store> getAllStores(int first, int maxResult) {
        return entityManager.createNamedQuery(Store.FIND_ALL)
                .setFirstResult(first).setMaxResults(maxResult).getResultList();
    }

    public Store getStoreByCode(int code){
        return entityManager.find(Store.class, code);
    }

    public void createStore(Store store) {
        entityManager.persist(store);
    }

    public Store updateStore(int code, Store store) {
        Store storeToUpdate = entityManager.find(Store.class, code);
        storeToUpdate.setName(store.getName());
        storeToUpdate.setDescription(store.getDescription());
        storeToUpdate.setType(store.getType());
        storeToUpdate.setOwner(store.getOwner());
        storeToUpdate.setUbication(store.getUbication());
        storeToUpdate.setDates(store.getDates());
        storeToUpdate.setImg(store.getImg());
        return entityManager.merge(storeToUpdate);
    }

    public void deleteStore(int code) {
        Store store = entityManager.find(Store.class, code);
        entityManager.remove(store);
    }
}
