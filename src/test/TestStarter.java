package test;

import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import test.app.utils.*;
import test.app.models.*;

import java.io.PrintWriter;

public class TestStarter {

    public static void main(String[] args){

        SummaryGeneratingListener summaryGeneratingListener = new SummaryGeneratingListener();

        var launcher =   LauncherFactory.create();
        LauncherDiscoveryRequest launcherDiscoveryRequest = LauncherDiscoveryRequestBuilder
                .request()
                .selectors(DiscoverySelectors.selectClass(ProductIDiscountModelTest.class))
                .selectors(DiscoverySelectors.selectClass(ProductModelTest.class))
                .selectors(DiscoverySelectors.selectClass(RounderTest.class))
                .build();
        launcher.execute(launcherDiscoveryRequest,summaryGeneratingListener);

        try (var writer = new PrintWriter(System.out)) {
            summaryGeneratingListener.getSummary().printTo(writer);
        }
    }

}

