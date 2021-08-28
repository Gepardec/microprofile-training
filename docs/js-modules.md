# Javascript Modules

## Modules

There are several global javascript modules which are used by developers in their own javascript modules.

The global javascript modules are located at the root level of `src/main/webapp/resources/js/` and are imported in the view specific javascript modules via
relative references.

````javascript 
import globalModule from '../../globalModule.js'
````

### mp

A simple utility module for global usable functionality.

#### Functions

`registerOnLoad` registers a function to the `DOMContentLoaded` event which guarantees that the page has been fully loaded and that the DOM is ready.

Usage
````javascript
mp.registerOnLoad((event) => myModule.init({...}));
````

### httpClient

A simple http client wrapping the javascript fetch api.

Take a look at [MDN Promise](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise) to learn how to work with promises.

Take a look at [MDN Fetch-API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch) to see how to work with the response which itself is again a promise.
#### Functions

`post` executes a post request and returns a promise with the return value of the provided callback function. If no callback is defined, then the fetch-api
response is the return value.

Usage:

````javascript
httpClient.post({
    uri: 'http://localhost:8080/api/endpoint',
    successCallback: (response) => extractData(response),
    errorCallback: (response) => extractData(response),
}).then((data) => displayData(data))
    .catch((error) => console.log('A network eror occurred'))
    .finally(() => console.log("Call is finished"));        
````

`postNTimes` executes a post request n-times and returns a promise array with the return value of the provided callback function. If no callback is defined,
then the fetch-api response is the return value.

Usage:

````javascript
httpClient.postNTimes({
    uri: 'http://localhost:8080/api/endpoint',
    count: 2,
    successCallback: (response, callCount) => extractData(response, callCount),
    errorCallback: (response, callCount) => extractData(response, callCount),
}).then((data) => displayData(data))
    .catch((error) => displayError(error))
    .finally(() => console.log("Call is finished"));                               
````
