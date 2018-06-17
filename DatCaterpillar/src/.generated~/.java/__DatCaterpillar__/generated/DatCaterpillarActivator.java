package __DatCaterpillar__.generated;

import ej.wadapps.management.ActivitiesList;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleActivator;

@SuppressWarnings("all")
public class DatCaterpillarActivator implements BundleActivator {

	fr.datcaterpillar.MainActivity fr__datcaterpillar__MainActivity;

	@Override
	public void initialize() {
		this.fr__datcaterpillar__MainActivity = new fr.datcaterpillar.MainActivity();
	}

	@Override
	public void link() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.add(this.fr__datcaterpillar__MainActivity);

	}

	@Override
	public void start() {
	}

	@Override
	public void stop() {
		ActivitiesList activitieslist = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		activitieslist.remove(this.fr__datcaterpillar__MainActivity);

	}

}