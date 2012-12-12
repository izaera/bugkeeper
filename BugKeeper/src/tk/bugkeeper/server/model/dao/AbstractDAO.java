package tk.bugkeeper.server.model.dao;

import java.util.List;

import tk.bugkeeper.server.model.entity.AbstractEntity;

import com.google.web.bindery.requestfactory.shared.Locator;

public abstract class AbstractDAO<ENTITY_TYPE extends AbstractEntity> extends Locator<ENTITY_TYPE,String> {

	protected EntityManager entityManager;
	private Class<ENTITY_TYPE> domainType;

	protected AbstractDAO( EntityManager entityManager, Class<ENTITY_TYPE> domainType ) {
		this.entityManager = entityManager;
		this.domainType = domainType;
	}
	
	public List<ENTITY_TYPE> findAll() {
		return entityManager.findAll(domainType);
	}
	
	public ENTITY_TYPE findById( final String id ) {
		return entityManager.findById( domainType, id );
	}

	public void save( final ENTITY_TYPE artifact ) {
		entityManager.save(artifact);
	}

	public void delete( final ENTITY_TYPE artifact ) {
		entityManager.delete(artifact);
	}

	///////////////////////////////////////////////////////////////////////////
	// Locator implementation
	///////////////////////////////////////////////////////////////////////////

	@Override
	public ENTITY_TYPE create(Class<? extends ENTITY_TYPE> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public final Class<ENTITY_TYPE> getDomainType() {
		return domainType;
	}

	@Override
	public final Class<String> getIdType() {
		return String.class;
	}

	@Override
	public ENTITY_TYPE find(Class<? extends ENTITY_TYPE> clazz, String id) {
		return findById(id);
	}

	@Override
	public String getId(ENTITY_TYPE domainObject) {
		return domainObject.getId();
	}

	@Override
	public Object getVersion(ENTITY_TYPE domainObject) {
		return domainObject.getVersion();
	}
}
