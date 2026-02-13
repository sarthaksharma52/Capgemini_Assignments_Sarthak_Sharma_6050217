package Feb13;

import java.util.*;

/*
  LOCAL DRIVER VERSION
  --------------------------------
  Implement ONLY the TODO methods.
  Do not change method signatures.
*/

enum ActionEnum {
    feature1Button,
    feature2Button,
    feature3Button
}

interface AnalyticsStore {
    void storeActions(Queue<ActionEnum> actions);
}

class InMemoryAnalyticsStore implements AnalyticsStore {

    private List<ActionEnum> storedActions = new ArrayList<>();

    @Override
    public void storeActions(Queue<ActionEnum> actions) {
        // For local testing ONLY
        while (!actions.isEmpty()) {
            storedActions.add(actions.poll());
        }
    }

    public List<ActionEnum> getStoredActions() {
        return storedActions;
    }
}

interface IAnalytics {

    void registerAction(ActionEnum action);

    int getNumberOfActionRegisteredButNotSentToAnalyticsStore();

    int getTotalNumberOfLoggedActions();

    List<ActionEnum> getMostFrequentlyUsedActions();
}

class Analytics implements IAnalytics {

    private AnalyticsStore analyticsStore;
    private int K;
    private Queue<ActionEnum> buffer;
    private Map<ActionEnum, Integer> freqMap;
    private int totalActions;

    public Analytics(AnalyticsStore analyticsStore, int K) {
        this.analyticsStore = analyticsStore;
        this.K = K;
        this.buffer = new LinkedList<>();
        this.freqMap = new HashMap<>();
        this.totalActions = 0;
    }

    @Override
    public void registerAction(ActionEnum action) {
        // TODO: implement
//        InMemoryAnalyticsStore i1 = new InMemoryAnalyticsStore();
        buffer.add(action);
        totalActions++;

        freqMap.put(action , freqMap.getOrDefault(action , 0) + 1);
        if(buffer.size() == K){
            analyticsStore.storeActions(buffer);
        }
    }

    @Override
    public int getNumberOfActionRegisteredButNotSentToAnalyticsStore() {
        // TODO: implement
        return buffer.size();
    }

    @Override
    public int getTotalNumberOfLoggedActions() {
        // TODO: implement
        return totalActions;
    }

    @Override
    public List<ActionEnum> getMostFrequentlyUsedActions() {
        // TODO: implement
        List<ActionEnum> ls = new ArrayList<>();
        int max = 0;

        for(int freq : freqMap.values()){
            max = Math.max(max,freq);
        }

        for(Map.Entry<ActionEnum , Integer> entry : freqMap.entrySet()){
            ActionEnum mostFreq = entry.getKey();

            if(entry.getValue() == max){
                ls.add(mostFreq);
            }

        }
        return ls;
    }
}

public class AnalyticSystemToTrackActionPerformed {

    public static void main(String[] args) {

        InMemoryAnalyticsStore store = new InMemoryAnalyticsStore();
        Analytics analytics = new Analytics(store, 3);

        analytics.registerAction(ActionEnum.feature1Button);
        analytics.registerAction(ActionEnum.feature1Button);

        System.out.println(analytics.getTotalNumberOfLoggedActions());

        analytics.registerAction(ActionEnum.feature2Button);
        analytics.registerAction(ActionEnum.feature3Button);

        System.out.println(
                analytics.getNumberOfActionRegisteredButNotSentToAnalyticsStore()
        );

        analytics.registerAction(ActionEnum.feature2Button);

        List<ActionEnum> mostUsed = analytics.getMostFrequentlyUsedActions();
        for (ActionEnum action : mostUsed) {
            System.out.print(action + " ");
        }

        System.out.println();

        for (ActionEnum action : store.getStoredActions()) {
            System.out.print(action + " ");
        }
    }
}
