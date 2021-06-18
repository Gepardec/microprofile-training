# Project Guide

This page represents the guide which will help you to setup the project on your local machine and tells you how to contribute to the project.

The project is based on the following listed specifications.

* `Jakarte-EE-8`
* `Microprofile 3.3`
* `Jakarta-MVC-1.1.0` (JSF as template engine)

The project uses the following client side libraries.

* `MDB-3.6.0` (Based on Bootstrap 5.Final)
* `Fontawesome-5.15.2`

## System Requirements

This project depends on the following software:

1. [OpenJDK-11](https://jdk.java.net/11/)
2. [Wildfly-23.0.2.Final](https://www.wildfly.org/downloads/)
3. [Maven-3.x.x](https://maven.apache.org/download.cgi)
4. [Docker](https://docs.docker.com/engine/)
5. [Docker Compose](https://docs.docker.com/compose/)

## How to setup your environment

Install the depending software, check out the github repository and setup the IDE of your choice.
See the repository root README for further details.

## How to provide documentation

All of our documentation is done in this Github WIKI which relates to the projects repository.

# How to use Git Branching

We use the simple [Github-Flow](https://guides.github.com/introduction/flow/) because we need no special version handling. 
We name our feature branches `feature/<ticket_id_or_expresive_name>` and merge them via reviewed Merge-Requests.

# Implementation Guide

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

```
@Path("/path")
@RequestScoped
@Controller
public class MyController {

    @Path("/")
    @GET
    public String get() {
        return "path/index.html";
    }

    @Path("/action")
    @GET
    public String action() {
        // Do something and return the page
        return get();
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

### JSF GUI Components

#### Tags

The custom JSF tags implement GUI components which are used globally.

`xmlns:tag="http://tags.microprofile.training.gepardec.com"` 

##### Button

Attributes:

1. `text`  
The text for the button
2. `path` (Optional)  
The relative path from the rest application path on, or a in-page references via '#'
3. `rendered` (Optional, default true)  
The rendered flag

```
<tag:button text="Go to example"/>
<tag:button text="Go to example" path="#otherId"/>
<tag:button text="Go to example" path="/basic/index"/>
```

##### Link

Attributes:

1. `text`  
The text for the button
2. `path` (Optional)  
The relative path from the rest application path on, or a in-page references via '#'
3. `target`  
The link target (Optional, default _self)
4. `rendered` (Optional, default true)  
The rendered flag

```
<tag:link text="Go to example"/>
<tag:link text="Go to example" path="#otherId"/>
<tag:link text="Go to example" path="/basic/index" target="_blank"/>
```

##### Card

The following attributes are required:

1. `id`  
The unique card id within a view
2. `title`   
The card title
3. `rendered` (Optional, default true)  
The rendered flag

```
<tag:card id="test" title="First part">
    <ui:define name="body">
        <p>...</p>
    </ui:define>
    <ui:define name="buttons">
        <tag:button text="Go to example" path="/basic/index"/>
    </ui:define>
</tag:card>
```

## How to provide static resources

In `Jakarta-MVC` static resources can be provided when located in the `webapp` directory. The static resources are referenced via normal links, 
no `JSF` involved. 

The main thing to consider is that the `@ApplicationPath(...)` of the `JAX-RS Application` must not define the root path, because the rest engine cannot provide the static resources.

The static resource are organized in the root directory `src/main/webapp/resources` and with the following structure.

* `/<framework>-<version>`   
The directory for a framework such as `mdb` which also defines the version.  
If a webjar of the used framework exists, then the webjar should be used.
* `/css`   
The directory for all of the applications stylings.
* `/img`   
The directory for all of the applications images.
   * `/<context>`  
   The directory holding the images for a context
      * `/<view>`  
      The directory holding the images for a context view

All provided images must be `PNG` files.