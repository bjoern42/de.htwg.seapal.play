package de.htwg.seapal.database.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.ektorp.CouchDbConnector;
import org.ektorp.support.CouchDbRepositorySupport;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import de.htwg.seapal.database.IWaypointDatabase;
import de.htwg.seapal.model.IWaypoint;
import de.htwg.seapal.model.impl.Waypoint;
import de.htwg.seapal.utils.logging.ILogger;

public class WaypointDatabase extends CouchDbRepositorySupport<Waypoint> implements
		IWaypointDatabase {

	private final ILogger logger;
	
	@Inject
	protected WaypointDatabase(@Named("waypointCouchDbConnector") CouchDbConnector db, ILogger logger) {
		super(Waypoint.class, db);
		this.logger = logger;
	}

	@Override
	public boolean open() {
		logger.info("WaypointDatabase", "Database connection opened");
		return true;
	}

	@Override
	public UUID create() {
		return null;
	}

	@Override
	public boolean save(IWaypoint data) {
		add((Waypoint) data);

		return false;
	}

	@Override
	public Waypoint get(UUID id) {
		return get(id.toString());
	}

	@Override
	public List<IWaypoint> loadAll() {
		return new LinkedList<IWaypoint>(getAll());
	}

	@Override
	public void delete(UUID id) {
		remove(get(id));
	}

	@Override
	public boolean close() {
		return true;
	}

}
