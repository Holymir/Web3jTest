pragma solidity ^0.4.18;

contract Kur {

    address owner;
    mapping(address => string) map;

    function Kur(){
        owner = msg.sender;
    }

    function addCar(string _newCar) {
        map[owner] = _newCar;
    }

}
