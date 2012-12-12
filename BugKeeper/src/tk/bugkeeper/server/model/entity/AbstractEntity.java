package tk.bugkeeper.server.model.entity;

import java.util.UUID;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Version;

public abstract class AbstractEntity {

	@Id private String id;
	@Version private Long version;

	public AbstractEntity() {
		id = UUID.randomUUID().toString();
	}

	public AbstractEntity( String id ) {
		this.id = id;
	}
	
	public final String getId() {
		return id;
	}
	
	public final Long getVersion() {
		return version;
	}

}
