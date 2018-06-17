package __DatCaterpillar__.generated;

import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.components.registry.BundleRegistry;
import ej.wadapps.management.ActivitiesScheduler;
import ej.wadapps.management.ActivitiesList;
import ej.wadapps.app.Activity;
import ej.wadapps.registry.SharedRegistryFactory;

@SuppressWarnings("all")
public class MainActivityStandalone {

	public static void main(String[] args) {
		SharedRegistryFactory.getSharedRegistry().register(BundleRegistry.class, new WadappsRegistry());

		// Start entry point.
		new DatCaterpillarEntryPoint().start();

		// Show MainActivity	
		ActivitiesScheduler activitiesScheduler = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesScheduler.class);
		ActivitiesList activitiesList = ServiceLoaderFactory.getServiceLoader().getService(ActivitiesList.class);
		Activity[] activities = activitiesList.getActivities();
		for (Activity activity : activities) {
			if(activity instanceof fr.datcaterpillar.MainActivity) {
				activitiesScheduler.show(activity);
				break;
			}
		}
	}

}