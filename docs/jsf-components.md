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

```
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

```
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

```
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

```
<tag:card id="indexExampleMpHealth" title="First part">
    <ui:define name="body">
        <p>...</p>
    </ui:define>
    <ui:define name="buttons">
        <tag:button id="toMpHealthExample" text="Go to example" path="/basic/health"/>
    </ui:define>
</tag:card>
```