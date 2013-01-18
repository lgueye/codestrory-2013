/**
 *
 */
package org.diveintojee.codestory.stories;

import org.diveintojee.codestory.steps.Exchange;
import org.diveintojee.codestory.steps.Q2Steps;
import org.diveintojee.codestory.steps.Q3Steps;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
public class Q3Story extends AbstractJUnitStories {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new Q3Steps(new Exchange()));
    }

    @Override
    protected List<String> storyPaths() {
        List<String> paths = new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(getClass()).getFile(),
                Arrays.asList("**/q3.story"), null);
        return paths;
    }
}
