# Javascript

Inline javascript must be avoided, and all javascript for a page is implemented in its own file as a javascript ES-6 module.

## Javascript modules

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

### Structure

Javascript modules are implement at least in the following way.

```
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
