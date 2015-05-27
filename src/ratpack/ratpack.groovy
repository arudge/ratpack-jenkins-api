import com.google.inject.Scopes
import jenkins.job.dashboard.IndexHandler

import static ratpack.groovy.Groovy.ratpack

ratpack {

    bindings {
        binder { b ->
            b.bind(IndexHandler).in(Scopes.SINGLETON)
        }
    }

    handlers {
        handler('', registry.get(IndexHandler))

    }
}

