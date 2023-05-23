package src.com.session.summer.programs;

import src.com.session.summer.view.Executor;
import src.com.session.summer.view.Printer;
import src.com.session.summer.view.Reader;

public abstract class SimplePrograms implements Executor {
    protected final Reader reader;
    protected final Printer printer;

    protected SimplePrograms(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

}
