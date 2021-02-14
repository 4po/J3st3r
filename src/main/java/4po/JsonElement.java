package objectivetester;

/**
 *
 * @author steve
 */
class JsonElement {

    Object elementObject;
    Type elementType;

    JsonElement(Object elementObject, Type elementType) {
        this.elementObject = elementObject;
        this.elementType = elementType;
    }

    @Override
    public String toString() {
        //debug
        //return this.elementType.toString()+this.elementObject.toString();
        return this.elementObject.toString();
    }

}

enum Type {
    ARRAY, KEY, VALUE, ARRAYKEY
}
