# Javascript Components

## Modules

There are several global Javascript modules which are used by developers in page related Javascript modules and/or in JSF pages.

The global javascript modules are located at the root level of `src/main/webapp/resources/js/` and are imported in the page related javascript modules via a
relative reference.

````javascript 
import globalModule from '../../globalModule.js'
````

### mp

A simple utility module.

#### Functions

`registerOnLoad`  
registers a function to the `DOMContentLoaded` event which guarantees that the page has been fully loaded and that the DOM is ready.

````javascript
mp.registerOnLoad((event) => myModule.init({ ... }));
````

`registerClickListenerPreventDefault`  
registers a function to the `click` event on a DOM element and prevents the default event invocation.

````javascript
mp.registerClickListenerPreventDefault(myElement, (event) => onClick());
````

### httpClient

A simple http client wrapping the Javascript fetch api.

Take a look at [MDN Promise](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise) to learn how to work with promises.

Take a look at [MDN Fetch-API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch) to see how to work with the response which itself is
again a promise.

#### Functions

`post`  
executes a post request and returns a promise with the return value of the provided callback function. If no callback is defined, then the fetch-api response is
the return value.

````javascript
httpClient.post({
    uri: 'http://localhost:8080/api/endpoint',
    successCallback: (response) => extractData(response),
    errorCallback: (response) => extractData(response),
}).then((data) => displayData(data))
    .catch((error) => console.log('A network eror occurred'))
    .finally(() => console.log("Call is finished"));        
````

`postBatch`  
executes parallel post request and returns a promise array with the return value of the provided callback function. If no callback is defined, then the
fetch-api response is the return value.

Be aware that there is a limitation of how many parallel request a browser can send with HTTP/1 protocol. Read the
doc [MDN Domain Sharding](https://developer.mozilla.org/en-US/docs/Web/HTTP/Connection_management_in_HTTP_1.x#domain_sharding) for more information.

````javascript
httpClient.postBatch({
    uri: 'http://localhost:8080/api/endpoint',
    count: 2,
    successCallback: (response, callCount) => extractData(response, callCount),
    errorCallback: (response, callCount) => extractData(response, callCount),
}).then((data) => displayData(data))
    .catch((error) => displayError(error))
    .finally(() => console.log("Call is finished"));                               
````

### timer

The timer module is used for invoking a function continuously with a specified delay and provides control functions for starting stopping the timer.

#### Functions

`create`  
creates a timer instance initialized with the options.

````javascript
const timer = timer.create({
    delayMillis: 5000,
    runFunction: runFunc,
    runData: runDataObj,
    startCallback: beforeStart,
    stopCallback: afterStop,
});
````

#### Classes

##### Timer

The Timer which handles the intervals and provides functions for controlling the underlying interval.

###### Functions

`start`  
invokes the `options.startCallback` function and starts the timer only if not already started. The `options.runData` is set as the input parameter for the
provided `options.runFunction`.

````javascript
timer.start();
````

`stop`  
stops the timer and invokes the `options.stopCallback` function only if the timer is running.

````javascript
timer.stop();
````

`restart`  
invokes the `stop` and then the `start` function.

````javascript
timer.restart();
````

`isRunning`  
Answers the question if the timer is running.

````javascript
timer.isRunning();
````

### modalDialog

A wrapper for interacting with an MDB modal dialog.  
If the Javascript object for the dialog doesn't exist for the provided html element, then it is created, otherwise the existing Javascript object is used.

#### Functions

`init`  
registers the show and hide callbacks on the html element if provided.

````javascript
modalDialog.init({
    element: element,
    showCallback: onShow,
    hideCallback: onHide,
})
````

`create`  
calls `init` for the callback registration and creates a ModalDialog instance.

````javascript
const dialog = modalDialog.init({
    element: element,
    showCallback: onShow,
    hideCallback: onHide,
})
````

#### Classes

##### ModalDialog

A wrapper for the MDB modal dialog for interacting with the underlying dialog.

###### Functions

`show`  
shows the modal dialog.

````javascript
dialog.show();
````

`hide`  
hide the modal dialog.

````javascript
dialog.hide();
````

### inputNumber

InputNumber is a wrapper for the MDB input number which clears an invalid content onblur and sets the defined min attribute if defined.

#### Functions

`init`  
register an onblur event listener creates the MDB input instance if not already instantiated.

````javascript
inputNumber.init(outlineDiv);
````

`update`  
updates the MDB input for recalculation of the outline label if MDB input is available.

Usage:

````javascript
inputNumber.update(outlineDiv);
````
