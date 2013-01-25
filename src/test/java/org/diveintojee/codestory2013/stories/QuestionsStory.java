/**
 *
 */
package org.diveintojee.codestory2013.stories;

import org.diveintojee.codestory2013.steps.Exchange;
import org.diveintojee.codestory2013.steps.QuestionsSteps;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
public class QuestionsStory extends AbstractJUnitStories {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new QuestionsSteps(new Exchange()));
    }

    @Override
    protected List<String> storyPaths() {
        List<String> paths = new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(getClass()).getFile(),
                Arrays.asList("**/questions.story"), null);
        return paths;
    }
}
