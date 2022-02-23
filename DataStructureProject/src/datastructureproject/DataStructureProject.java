/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package datastructureproject;

import java.util.Scanner;

/**
 *
 * @author mrsci
 */
public class DataStructureProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int secim = -2;
       
       BinarySearchTree my_tree = new BinarySearchTree();
       MyDoubleLinkedList<String> my_list = new MyDoubleLinkedList<>();
       HashTable my_hash = new HashTable();
       
       
        while(secim != -1 ){
            System.out.println("HOŞGELDİNİZ!!!");
            System.out.println("MENÜ:...0 ÇIKIŞ - 1 ÖĞRENCİ EKLE - 2 öĞRENCİ SİL - 3 öĞRENCİ BUL"
                    + " - 4 TÜM ÖĞRENCİLERİ LİSTELE - 5 FARKLI İSİMLERİ LİSTELE - 6 ISIMLER KAÇ KER KULLANILMIS LİSTELE"
                    + " - 7 HAKKINDA");
            Scanner input = new Scanner(System.in);
            System.out.println("LÜTFEN YAPMAK İSTEDİĞİNİZ İŞLEMİN NUMRASINI GİRİNİZ: ");
            secim = input.nextInt();
            
            if(secim==0){
                System.out.println("SİSTEMDEN ÇIKMAK İSTİYOR MUSUNUZ? EVET=-1 , HAYIR=-2 ");
                secim = input.nextInt();
                if (secim == -1){
                    System.out.println("ÇIKIŞ YAPILIYOR... HOŞÇAKALIN");
                    break;
                }
                else{
                    // menüyü tekrar döndürsün
                }
            }
            else if (secim ==1){
                Scanner input_name = new Scanner(System.in);
                System.out.println("KAYIT OLACAK ÖĞRENCİNİNİN İSMİNİ GİRİNİZ:");
                String ogrenci_ismi = input_name.nextLine();
                
                Scanner input_surname = new Scanner(System.in);
                System.out.println("KAYIT OLACAK ÖĞRENCİNİN SOYİSMİNİ GİRİNİZ:");
                String ogrenci_soyismi = input_surname.nextLine();
                
                Scanner input_id = new Scanner(System.in);
                System.out.println("KAYIT OLACAK ÖĞRENCİNİN NUMARASINI GİRİNİZ:");
                int numara = input_id.nextInt();
                
                my_tree.node_ekleme(ogrenci_ismi, ogrenci_soyismi, numara); //binary seacrh tree de oluşturuldu
                my_list.listeye_ekleme(ogrenci_ismi, ogrenci_soyismi, numara); // list de oluşturuldu
                my_hash.insert(numara , ogrenci_ismi , ogrenci_soyismi); // hashtable yapsında kullandık  
            }
            else if(secim==2){
                Scanner input_silinecek_kişi_id = new Scanner ( System.in);
                System.out.println("SİLMEK İSTEDİĞİNİZ ÖĞRENCİNİN ÖĞRENCİ NUMARASINI GİRİNİZ:");
                int silinecek_id = input_silinecek_kişi_id.nextInt();
                
                my_tree.node_sil(silinecek_id);
                my_list.ogrenci_silme(silinecek_id);
                my_hash.silme(silinecek_id);
            }
            else if(secim==3){
                Scanner input_bulunacak_kişi_id = new Scanner ( System.in);
                System.out.println("BULMAK İSTEDİĞİNİZ ÖĞRENCİNİN ÖĞRENCİ NUMARASINI GİRİNİZ:");
                int aranan_id = input_bulunacak_kişi_id.nextInt();
                
                my_tree.findNode(aranan_id);
                my_list.bulma(aranan_id);
                my_hash.contains(aranan_id);

                
            }
            else if (secim ==4){
                Scanner input_sıralama = new Scanner (System.in);
                System.out.println("LİSTELENECEK ÖĞRENCİLİER HANGİ VERİ YAPISINA GÖRE LİSTELENSİN ?");
                System.out.println("1 BİNARY SEARCH TREE - 2 LİST - 3 HASH");
                int input_siralama_secme = input_sıralama.nextInt();
                if (input_siralama_secme == 1){
                    System.out.println("PREORDER SIRALAMA...");
                    my_tree.node_listele(my_tree.getMy_node());
                }
                else if (input_siralama_secme==2){
                    my_list.listele();
                }
                else{
                    my_hash.listeleHashTable();
                }  
            }
            
            else if (secim==5){
                my_list.isim_islemleri(5);
            }
            else if (secim==6){
                my_list.isim_islemleri(6);
                
            }
            else if (secim==7){
                System.out.println("180315034-İLAYDA ÇITAK");
            }
            else {
                System.out.println("YANLIŞ BİR TUŞLAMA YAPTINIZ , LÜTFEN TEKRAR DENEYİN");
                secim = -2 ;
            }
        }
    }
    
}
