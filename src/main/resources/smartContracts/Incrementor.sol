pragma solidity ^0.4.10;

contract Incrementor {
    uint private x;
    
    function increment(uint plus) public{
        x += plus;
    }
    
    function getX() public view returns (uint) {
        return x;
    }
}