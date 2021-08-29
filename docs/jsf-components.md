# JSF Components

## Tags

The custom JSF tags implement GUI components which are used globally.

`xmlns:tag="http://tags.microprofile.training.gepardec.com"`

### Button

Renders a link acting as a button, for executing GET requests like with a link.

Attributes:

1. `id`  
   The page unique id
2. `text`  
   The text for the button
3. `path` (Optional, Default='#')  
   The relative path from the rest application path on, or a in-page references via '#'
4. `rendered` (Optional, Default=true)  
   The rendered flag

```xml
<tag:button id="toMyActionOrResource" text="Go to example"/>
<tag:button id="toMyActionOrResource" text="Go to example" path="#otherId"/>
<tag:button id="toMyActionOrResource" text="Go to example" path="/basic/index"/>
```

### Link

Renders an ordinary link with a text for executing GET requests.  
The component accepts children, for instance an icon.

Attributes:

1. `id`  
   The page unique id
2. `text` (Optional)    
   The text for the link
3. `path` (Optional, Default='#')  
   The relative path from the rest application path on, or a in-page references via '#'.
4. `target` (Optional, Default='_self')  
   The link target
5. `rendered` (Optional, Default=true)  
   The rendered flag

```xml
<tag:link id="toMyActionOrResource" text="Go to example"/>
<tag:link id="toMyActionOrResource" text="Go to example" path="#otherId"/>
<tag:link id="toMyActionOrResource" text="Go to example" path="/basic/index" target="_blank"/>
<tag:link id="toMyActionOrResource" text="Go to example" path="/basic/index" target="_blank">
    <i class="fas fa-arrow"/>
</tag:link>
```

### NavLink

Renders a nav link with a text for executing GET requests from the navbar.  
The link is marked active if the user is on the current page or if the ``active`` flag ist set.  
The component accepts children, for instance an icon.

Attributes:

1. `id`  
   The page unique id
2. `path`  
   The relative path from the rest application path on
3. `text` (Optional)
   The text for the link
4. `rendered` (Optional, Default=true)  
   The rendered flag
5. `active` (Optional, Default=false)  
   The active flag marking the nav link active

```xml
<tag:navLink id="toMyResource" path="/basic/index" text="Go to example"/>
<tag:navLink id="toMyResource" text="Go to example" path="/basic/index" active="#{pathHelper.isOnSubpage('/basic/config')}">
    <i class="fas fa-arrow"/>
</tag:navLink>
```

### Card

Renders a card with a header and button section used for an element in teh index pages.

Attributes:

1. `id`  
   The unique card id within a view
2. `title`   
   The card title
3. `rendered` (Optional, default true)  
   The rendered flag

```xml
<tag:card id="indexExampleMpHealth" title="First part">
    <ui:define name="body">
        <p>...</p>
    </ui:define>
    <ui:define name="buttons">
        <tag:button id="toMpHealthExample" text="Go to example" path="/basic/health"/>
    </ui:define>
</tag:card>
```

### ModalDialog

Renders a modal dialog which displays the content provided.   
This component is useful when one wants to display a message to the user.

Attributes:

1. `id`  
   The page unique id
2. `title` (Optional)
   The title of the timer dialog
3. `text` (Optional)
   The text of the timer dialog
4. `closable` (Optional)
   The flag indicating the user can close the dialog

```xml
<tag:modalDialog id="message" />
<tag:modalDialog id="message" title="Information" />
<tag:modalDialog id="message" title="Information" text="Informative message"/>
```

The timer dialog can be controlled in Javascript via the [Javascript Component](#modalDialog) where the html element to provide has the id you provided for the tag.


### TimerDialog

Renders a timer modal dialog which displays a spinner and the duration seconds the dialog is displayed.   
This component is useful when one wants to display the duration of a rest-api call.  
This component is based on the Modal Dialog Component.

Attributes:

1. `id`  
   The page unique id 
2. `title` (Optional)
   The title of the timer dialog
3. `text` (Optional)
   The text of the timer dialog
4. `closable` (Optional)
   The flag indicating the user can close the dialog

```xml
<tag:timerDialog id="timer" />
<tag:timerDialog id="timer" title="Waiting for response..." />
<tag:timerDialog id="timer" title="Waiting for response..." text="This should not take longer than 1 second"/>
```

The timer dialog can be controlled in Javascript via the [Javascript Component](#modalDialog) where the html element to provide has the id you provided for the tag.
