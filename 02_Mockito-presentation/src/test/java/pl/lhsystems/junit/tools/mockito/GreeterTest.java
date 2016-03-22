package pl.lhsystems.junit.tools.mockito;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by U534102 on 2015-12-17.
 * <p>
 * Test class presenting most basic Mockito features
 */
public class GreeterTest {

    @Test
    public void shouldAskAppConfigurationForLanguage() {
        //arrange
        AppConfiguration appConfigurationMock = mock(AppConfiguration.class);
        Greeter systemUnderTest = new Greeter(appConfigurationMock);

        //action
        systemUnderTest.greet();

        //verify that collaborator was invoked
        verify(appConfigurationMock).getLanguage();
    }

    @Test
    public void shouldReturnPolishGreetWhenAppLanguageIsSetToPolish() {
        //arrange
        AppConfiguration appConfigurationMock = mock(AppConfiguration.class);
        when(appConfigurationMock.getLanguage()).thenReturn("pl");
        Greeter systemUnderTest = new Greeter(appConfigurationMock);

        //action
        String greet = systemUnderTest.greet();

        //verify
        assertThat(greet, is("Witaj"));
    }

    @Test
    public void shouldReturnEnglishGreetWhenAppLanguageSetIsUnrecognized() {
        //arrange
        String anyUnrecognizedLanguage = "NON_EXISTING_LANGUAGE_SHORTCUT";
        AppConfiguration appConfigurationMock = mock(AppConfiguration.class);
        when(appConfigurationMock.getLanguage()).thenReturn(anyUnrecognizedLanguage);
        Greeter systemUnderTest = new Greeter(appConfigurationMock);

        //action
        String greet = systemUnderTest.greet();

        //verify
        assertThat(greet, is("Welcome"));
    }

}
