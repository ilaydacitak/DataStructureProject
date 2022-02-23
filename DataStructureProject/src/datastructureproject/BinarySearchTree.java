
package datastructureproject;

public class BinarySearchTree {
    
    private Node my_node;

    public Node getMy_node() {
        return my_node;
    }

    public void setMy_node(Node my_node) {
        this.my_node = my_node;
    }
    
    public BinarySearchTree(){
        my_node = new Node();
    }
    
    public void node_sil(int silinecek_id){
        this.my_node = node_sil_arama(this.my_node, silinecek_id);
    }
    
    private Node node_sil_arama(Node root, int sil_id){
        Node p, p2, n;
         if (root.getStudent_number() == sil_id)
         {
             Node lt, rt;
             lt = root.getLeft();
             rt = root.getRight();
             if (lt == null && rt == null)
                 return null;
             else if (lt == null)
             {
                 p = rt;
                 return p;
             }
             else if (rt == null)
             {
                 p = lt;
                 return p;
             }
             else
             {
                 p2 = rt;
                 p = rt;
                 while (p.getLeft() != null)
                     p = p.getLeft();
                 p.setLeft(lt);
                 return p2;
             }
         }
         if (sil_id < root.getStudent_number())
         {
             n = node_sil_arama(root.getLeft(), sil_id);
             root.setLeft(n);
         }
         else
         {
             n = node_sil_arama(root.getRight(), sil_id);
             root.setRight(n);             
         }
         return root;
     }
        
        
        /*Node p, p2, n;
        if (root.getStudent_number()== sil_id){
            left = root.getLeft();
            right = root.getRight();
            Node prv_ = root;
            
            left = root.getLeft();
            right = root.getRight();
            if (left == null && right == null){
                return null;
            }
            else if (left == null){
                p = right;
                return p;
            }
            else if (right == null){
                p = left;
                return p;
            }
            else{
                p2 = left; //50
                p = left; //200
                while (left.getRight()!= null){
                    
                    left = left.getRight(); // 55
                }
                
                
                left.setRight(root.getRight());
                left.setLeft(root.getLeft());
                my_node = left;           
                return my_node;
               
            }
        }
        else if (sil_id < root.getStudent_number()){
            n = node_sil_arama(root.getLeft(), sil_id);
            root.setLeft(n);
        }
        else{
            n = node_sil_arama(root.getRight(), sil_id);
            root.setRight(n);             
        }
        return root;*/
    
       
    public void node_listele(Node tempNode){  
        if(tempNode == null){
            return;
        }
        else{
            int number = tempNode.getStudent_number();
            if( number >= 0){
                System.out.println(String.valueOf(number) + " " + tempNode.getStudent_name() +
                        " " + tempNode.getStudent_surname());

                node_listele(tempNode.getLeft());
                node_listele(tempNode.getRight());

            }
        }
    }
    
    public void findNode(int aranan_id) {
        int tarama_sayisi = 0 ;

        tarama_sayisi =+1;
        findLeafNode(this.my_node, aranan_id,tarama_sayisi);
       
    }
    
    public void findLeafNode(Node node, int aranan_id,int tarama_sayisi){
        if (aranan_id == node.getStudent_number()){
            System.out.println("-------------BINARY SEACRH TREE-------------------");
            System.out.println("TARAMA SAYISI: "+tarama_sayisi);
            System.out.println("İSİM:"+node.getStudent_name()+" SOYİİSİM: "+node.getStudent_surname());
            
        }
        else if (aranan_id < node.getStudent_number()) {
            tarama_sayisi += 1;
            if (node.getLeft()!= null){
                findLeafNode(node.getLeft(),aranan_id,tarama_sayisi);
            }
            else{
                System.out.println("Öğrenci Bulunamadı");
            }
        } 
        else if (aranan_id > node.getStudent_number()) {
            tarama_sayisi += 1;
            
            if (node.getRight() != null){
                findLeafNode(node.getRight(),aranan_id,tarama_sayisi);
            }
            else{
                System.out.println("Öğrenci Bulunamadı");
            }
        }    
    }
    
    public void node_ekleme(String ogrenci_ismi, String ogrenci_soyismi ,int numara ){
        if (this.my_node.getNumber_of_student() == 0){
            this.my_node.setStudent_name(ogrenci_ismi);
            this.my_node.setStudent_surname(ogrenci_soyismi);
            this.my_node.setStudent_number(numara);
            this.my_node.setNumber_of_student(my_node.getNumber_of_student() + 1);
            this.my_node.setLeft(null);
            this.my_node.setRight(null);
        }
        else if(this.my_node.getNumber_of_student() > 0){
            Node tempNode = this.my_node;

            while(true){
                if(tempNode.getStudent_number() > numara){
                    if(tempNode.getLeft()==null){
                        Node new_node = new Node(null, null, numara, ogrenci_ismi, ogrenci_soyismi);
                        tempNode.setLeft(new_node);
                        break;
                    }
                    else{
                        tempNode = tempNode.getLeft();
                    }
                }
                else{
                    if(tempNode.getRight()==null){
                        Node new_node = new Node(null, null, numara, ogrenci_ismi, ogrenci_soyismi);
                        tempNode.setRight(new_node);
                        break;
                    }
                    else {
                        tempNode = tempNode.getRight();
                    }

                }
            }
        }

    }
}
