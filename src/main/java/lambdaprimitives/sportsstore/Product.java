/*
Hozz létre egy Product osztályt, amely a sportszer nevét, árát, darabszámát tárolja! A konstruktora is ezeket kapja meg, ugyanebben a sorrendben!
*/

package lambdaprimitives.sportsstore;

public record Product (String name, double price, int pieces ){
}
