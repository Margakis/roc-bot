# JSON Guidelines
JSON is short for JavaScript Object-Notation
You do not need to use JavaScript to use JSON, such as in our case. A JSON file starts with a __{__ and ends with an __}__, the two curly braces together form a javascript object, and everything between these are the _properties_ of the object. Hence a JSON-file is an object.

## Syntax
Not only the file itself is an object, all the properties inside the object are also objects.

	{
		another object": {
			1:2,
			2:7 
		}
	}
Here, we have an object containing _another object_, every object has an identifier and and a value. The identifier of the file-object mentioned in the beginning is the file itself, so no need to write anything there.
The value of _another object_ is the two objects with the identifiers _1_ and _2_, where _1_ has the value 2, and _2_ – the value 7. 
__Case:__  We do not do Camel case! Rather We do: _**H**elix **c**annon_.
There are some exception such as _Von Braun_ because _Braun_ is a place.
### Ships, weapons, auras and zens
1. Ships:
The ships are put in the _ships.json_ file under the res-folder and we do it as following:

	{
		"ships":[
				{
					"name":"name of the ship", "weapon":"name of the weapon", "aura": "name of the aura", "zen": "name of the zen", "r": NUMBER_FROM_1_TO_3_WHERE_1_IS_COMMON_AND_3_IS_SUPER_RARE
				},
				{
					...
				}
		]
	}



