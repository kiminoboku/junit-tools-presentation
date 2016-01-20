package pl.lhsystems.junit.tools.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by U534102 on 2015-12-17.
 *
 * Test class presenting most basic Mockito features
 */
@RunWith(MockitoJUnitRunner.class)
public class GreeterTest {

    @InjectMocks
    Greeter systemUnderTest;

    @Mock
    AppConfiguration appConfiguration;

    @Test
    public void greetShouldInvokeAppConfigurationForLanguage() {
        systemUnderTest.greet();

        //verify that collaborator was invoked
        verify(appConfiguration).getLanguage();
    }

    @Test
    public void greetShouldReturnPolishGreetWhenAppConfigurationReturnsPolishLanguage() {
        //return specific result when invoked
        when(appConfiguration.getLanguage()).thenReturn("pl");

        String greet = systemUnderTest.greet();

        assertThat(greet, is("Witaj"));
    }

    @Test
    public void greetShouldReturnEnglishGreetWhenAppConfigurationReturnsUnrecognizedLanguage() {
        String anyUnrecognizedLanguage = "NON_EXISTING_LANGUAGE_SHORTCUT";
        when(appConfiguration.getLanguage()).thenReturn(anyUnrecognizedLanguage);

        String greet = systemUnderTest.greet();

        assertThat(greet, is("Welcome"));
    }

}
