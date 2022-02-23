
package datastructureproject;

class MyDoubleLinkedList_Hash<AnyType> {
    
    private NodeList head;
    private NodeList tail;
    
    private int theSize = 0;

    
    public MyDoubleLinkedList_Hash() {
        head = new NodeList();
        theSize = 0;
    }

    public int getTheSize() {
        return theSize;
    }

    public void listeye_ekleme(String ogrenci_ismi, String ogrenci_soyismi ,int numara){
        if(theSize==0){
            head.setData_isim(ogrenci_ismi);
            head.setData_soyisim(ogrenci_soyismi);
            head.setData_numara(numara);
            head.setNext(null);
            head.setPrev(null);

            theSize++;
        }
        else if (theSize >= 1) {
            NodeList head = this.head;
            
            while(head.getNext() != null){
                head=head.next;
            }

            NodeList new_nodelist = new NodeList(head , ogrenci_ismi , ogrenci_soyismi ,numara, null );
            head.next = new_nodelist;
            new_nodelist.prev = head;
            tail = new_nodelist;
            theSize++;
        }
    }
    
    public void ogrenci_silme(int silinecek_id){
        
        if(silinecek_id == head.getData_numara()){
            if(head.next != null){
                head = head.next;
                head.setPrev(null);
            }
            else{
                head = null;
            }
            theSize --;
        }
        else if (silinecek_id == tail.getData_numara()){
            NodeList head = this.head;
            
            while(head.next.next != null){
                head=head.next;
            }
                head.next = null;
                //tail = head; 
                
                theSize--;
        }
        else {
            NodeList head = this.head;
            //head = head.next;
            
            while(head != null){
                if (head.next.getData_numara() == silinecek_id){
                    head.next = head.next.next;
                    head.next.prev = head;
                    
                    theSize--;
                    break;
                }
                else if(head.next != null){   
                   head = head.next;
                }
                else if(head.next == null){
                    break;
                }
            }
        }
    }
    
    public void bulma (int aranan_id){
        NodeList temp = this.head;
        for(int i =0; i< theSize; i++){
            if(aranan_id==temp.getData_numara()){
                System.out.println("---------------HASH TABLE------------");
                System.out.println("TARAMA SAYISI:"+(i+1));
                System.out.println("İSİM: "+temp.getData_isim() + " SOYİSİM: "+temp.getData_soyisim());
                 break;
                 
            }
            temp = temp.next;
        }  
    }
    
    public void listele(){
        NodeList temp = this.head;
        for(int i =0; i< theSize; i++){
            System.out.println("İSİM: "+temp.getData_isim() + " SOYİSİM: "+temp.getData_soyisim());
            temp = temp.next;
        }
    }

    
    
    ////////////////////////////////////////////////////////////////////////////////////
    private class NodeList<AnyType>{
        private NodeList<AnyType> prev;
        private AnyType data_isim;
        private AnyType data_soyisim;
        private int data_numara;
        private NodeList<AnyType> next;
 
        public NodeList(NodeList<AnyType> p, AnyType di, AnyType ds , int dn ,NodeList<AnyType> n){ 
            prev = p;
            data_isim = di;
            data_soyisim = ds;
            data_numara = dn;
            next = n;
        }

        public NodeList() {
            prev = null;
            data_isim = null ;
            data_soyisim=null;
            data_numara = -1 ;
            next = null ;
        }

        public AnyType getData_isim() {
            return data_isim;
        }

        public AnyType getData_soyisim() {
            return data_soyisim;
        }

        public int getData_numara() {
            return data_numara;
        }

        public NodeList<AnyType> getNext() {
            return next;
        }

        public NodeList<AnyType> getPrev() {
            return prev;
        }

        public void setData_isim(AnyType data_isim) {
            this.data_isim = data_isim;
        }

        public void setData_soyisim(AnyType data_soyisim) {
            this.data_soyisim = data_soyisim;
        }

        public void setData_numara(int data_numara) {
            this.data_numara = data_numara;
        }

        public void setNext(NodeList<AnyType> next) {
            this.next = next;
        }

        public void setPrev(NodeList<AnyType> prev) {
            this.prev = prev;
        }
          
    }
}
    