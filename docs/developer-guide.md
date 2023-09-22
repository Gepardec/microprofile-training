# Developer Guide

This page represents the guide which will help you setup the project on your local machine and tells you how to contribute to the project.

The project is based on the following listed specifications.

* `Jakarte-EE-8`
* `MicroProfile 4.1`
* `Jakarta-MVC-1.1.0` (JSF as template engine)

The project uses the following client side libraries in form os webjars.

* `MDB-3.9.0` (Based on Bootstrap 5.Final)
* `Fontawesome-5.15.2`

## System Requirements

This project depends on the following software:

1. [OpenJDK-17](https://jdk.java.net/17/)
2. [Wildfly-26.1.3.Final](https://www.wildfly.org/downloads/#26.1.3.Final)
3. [Maven-3.x.x](https://maven.apache.org/download.cgi)
4. [Docker](https://docs.docker.com/engine/)
5. [Docker Compose](https://docs.docker.com/compose/)

## How to set up your environment

Install the depending software, check out the github repository and setup the IDE of your choice.
See the repository root README for further details.

## How to provide documentation

All of our documentation is available as Github Pages, which relates to the projects repository.

## How to use Git Branching

We use the simple [Github-Flow](https://guides.github.com/introduction/flow/) because we need no special version handling. 
We name our feature branches `feature/<ticket_id_or_expresive_name>` and merge them via reviewed Merge-Requests.

## How to implement (MVC) Controllers

Controllers are JAX-RS endpoint classes with the naming scheme `*Controller` e.g. `MPConfigController`
which provide http based action endpoints and for views to render.

All controller classes need to be annotated with:

1. `@RequestScoped` because in MVC we are stateless
2. `@Controller` which enables the MVC framework for all contained methods

If not all contained endpoints return a view, then only those endpoint methods need to be annotated with `@Controller`
which return a view.

The http endpoint are named either as:

1. The http method used e.g. `@GET get()`
2. The action name e.g. `@Path("/action") action()`

The endpoints either return 

* `String` if a view is returned,
* or `Response` when no view is needed

See the following snippet for an example controller implementation.

```java
import javax.ws.rs.core.Response;

@Path("/path")
@RequestScoped
public class MyController {

    @Path("/")
    @GET
    @Controller
    public String get() {
        return "path/index.xhtml";
    }

    @Path("/action")
    @GET
    @Controller
    public String action() {
        // Do something and return the page
        return get();
    }

    @Path("/post")
    @POST
    public Response action() {
        // Do something and return the response
        return Response.ok().build();
    }
}
```

For further learning about `Jakarta-MVC` controller see the [Jakarta MVC 1.1.0 specification](https://jakarta.ee/specifications/mvc/1.1/jakarta-mvc-spec-1.1.html).

## How to implement (MVC) JSF views

The template engine we have chosen is `JSF` where we only use the templating part of `JSF` to provide us with common components, so 
that we have consistent views and an easy way to implement views. The rest is actually plain html, css, text and javascript.

The root directory for our views is `src/main/webapp/WEB-INF/views` where we organize our views with the following structure.

* `/context`  
The directory which encapsulates the resources and views of a context which could be for instance `basic` or `advanced`.
   - `/index.xhtml`  
   The index page for a context which is the entry point and contains the links to the several views. 
   - `/example-one.xhtml`  
   The view for the example one. 

See [section](#jsf-components) for a list of available JSF components for building GUIs.

## How to provide static resources

In `Jakarta-MVC` static resources can be provided when located in the `webapp` directory. The static resources are referenced via normal links, 
no `JSF` involved. 

The main thing to consider is that the `@ApplicationPath(...)` of the `JAX-RS Application` must not define the root path, because the rest engine cannot provide the static resources.

The static resource are organized in the root directory `src/main/webapp/resources` and with the following structure.

* `/<framework>-<version>`   
The directory for a framework such as `mdb` which also defines the version.  
If a webjar of the used framework exists, then the webjar should be used.
* `/css`   
The directory for all the applications stylings.
* `/img`   
The directory for all the applications images.
   * `/<context>`  
   The directory holding the images for a context
      * `/<view>`  
      The directory holding the images for a context view

All provided images must be `PNG` files.

## How to use javascript

Inline javascript must be avoided, and all javascript for a page is implemented in its own file as a javascript ES-6 module.

The root directory for all javascript files is `src/main/webapp/resources/js` where the javascript files are structured in subdirectories depending on the
context they are used for.

* `/`
  The directory for commonly used javascript modules, which can be used in any page and other javascript modules.
* `/tags`  
  The directory for javascript modules used by JSF tags.
* `/basic/<mp_spec>`
  The directory for all basic examples javascript modules of a specification.
* `/advanced/<mp_spec>`
  The directory for all advanced examples javascript modules of a specification.

Javascript modules are implement at least in the following way.

```javascript
// Optional state object
const state = {
    attribute: value,
};

// Optional (e.g.: click event listener registration)
const registerElementClickEventListener = (options) => {
    const {
        element,
    } = options;
    element.addEventListener('click', () => console.log('element clicked'));
};

const init = (options) => {
};

export default {
    init,
};
```

Parameters for the javascript module are always provided as an options object. If html elements are used in any ways, then the html element instance itself is
provided and never ids.

Javascript modules are used in a xhtml page the following way.

```xml
<!-- Inserts the contained tags at the end of the HTML page -->
<ui:define name="bottom"> 
    <!-- The used javascript is a javascript module -->
    <script type="module">
        // '#{pathHelper.buildResourcePath("/js/mp.js")}' is a EL-Expression which gets resolved to ''/mptraining/resources/js/mp.js''
        // Imports your modules
        import mp from '#{pathHelper.buildResourcePath("/js/mp.js")}'
        import myModule from '#{pathHelper.buildResourcePath("/js/basic/<MP_SPEC>/myModule.js")}'

        // Initializes your javascript module once per page load
        mp.registerOnLoad(() => myModule.init({
            ...
        }));
    </script>
</ui:define>
```

