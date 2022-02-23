
package datastructureproject;

import java.util.ArrayList;

class HashTable<K>{
    
    private static final int tableSize = 10;
    
    private ArrayList<MyDoubleLinkedList_Hash> HashList=new ArrayList<MyDoubleLinkedList_Hash>(tableSize);  
    
    public HashTable(){
        for(int i=0; i<tableSize; i++)   {  
            HashList.add(new MyDoubleLinkedList_Hash<>());
        }
    }
    private int myHash(Integer numara){
	
        return (numara % HashList.size());    
    }

    public void insert(Integer numara, String ogrenci_ismi, String ogrenci_soyismi){
        MyDoubleLinkedList_Hash<Integer> belirlenenHashListesi = HashList.get(myHash(numara));
        belirlenenHashListesi.listeye_ekleme(ogrenci_ismi, ogrenci_soyismi, numara);           
    }

    public void silme(Integer numara){
        MyDoubleLinkedList_Hash<Integer> belirlenenHashListesi = HashList.get(myHash(numara));
        belirlenenHashListesi.ogrenci_silme(numara);
           
    }

    public void contains(Integer numara){
        MyDoubleLinkedList_Hash<Integer> belirlenenHashListesi = HashList.get(myHash(numara));
	belirlenenHashListesi.bulma(numara);    
    }

    public void listeleHashTable(){
        MyDoubleLinkedList_Hash<Integer> belirlenenHashListesi;
        
        for(int i=0; i< HashList.size(); i++)
        {
            belirlenenHashListesi = HashList.get(myHash(i));
			
            System.out.print("|" + i + "|" + " --> ");                                                                             
            belirlenenHashListesi.listele();     
            
            System.out.println();                                
        }
    }

    


}