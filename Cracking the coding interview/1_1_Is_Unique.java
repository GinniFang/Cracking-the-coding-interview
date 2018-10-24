//Unicode 128
//ACSII 256



// With extra space Solution O(n)
boolean isUniqueChars(String tr){
    boolean[] check = new boolean[128];
    for(int i = 0;i<tr.length();i++){
        if(check[tr.charAt(i)]==false)
            check[tr.charAt(i)]=true;
        else return false;
    }
    return true;
}


// Without extra space O(n^2)
boolean isUniqueChars(String tr){
    for(int i=0;i<tr.length();i++){
        char c = tr.charAt(i);
        if(tr.indexof(c)!=tr.lastIndexOf(c)){
            return false;
        }
    }
    return true;
}

//With O(1) extra space using bitwise however, only
//can be use when the input only use lowercase 
//letter a through z
boolean is isUniqueChars(String str){
    int checker = 0;
    for(int i = 0;i<str.length();i++){
        int val = str.charAt(i) - 'a';
        if(checker & (1<<val) >0){
            return false;
        }
        checker |=(1<<val);
    }
    return true;
}
// explaination for (1<<val)
//create a int value that has all bits
//zero except for the val th bit, which
//left move one for val position.
//if the val position in checker is already
//exist, then return false, else set valth
//position in checker to be true 