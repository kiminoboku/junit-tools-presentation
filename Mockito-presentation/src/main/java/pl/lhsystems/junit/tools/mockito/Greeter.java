package pl.lhsystems.junit.tools.mockito;

/**
 * Created by U534102 on 2015-12-17.
 * An object producing greeting message depending of application language provided from AppConfiguration object
 */
public class Greeter {

    /**
     * Provides configuration
     */
    AppConfiguration appConfiguration;

    /**
     * Creates new Greeter with given application configuration
     *
     * @param appConfiguration app configuration to be used
     */
    public Greeter(AppConfiguration appConfiguration) {
        this.appConfiguration = appConfiguration;
    }

    /**
     * @return greet message depending on language returned by application configuration object. If application
     * configuration returns unrecognized language (for now anything except "pl"), this method will return a default
     * english greeting "Welcome".
     */
    public String greet() {
        String language = appConfiguration.getLanguage();

        if ("pl".equals(language)) {
            return "Witaj";
        }
        return "Welcome";
    }
}
