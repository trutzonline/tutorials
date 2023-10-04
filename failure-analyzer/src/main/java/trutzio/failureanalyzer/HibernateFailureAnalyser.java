package trutzio.failureanalyzer;

import org.hibernate.HibernateException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class HibernateFailureAnalyser extends AbstractFailureAnalyzer<HibernateException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, HibernateException cause) {
        return new FailureAnalysis(
                "It could be that this Hibernate error is a follow up error as the database connection could not be established.",
                "* doublecheck spring.datasource.username, " +
                        "spring.datasource.password or spring.datasource.url",
                cause);
    }

}
