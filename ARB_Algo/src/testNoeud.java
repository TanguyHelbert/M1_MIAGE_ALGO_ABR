

class TestNoeud <E>{
   private E element;
   private TestNoeud<E> gauche, droit;
   public TestNoeud (){ 
      element = null;
      gauche = null;
      droit = null;
   }

   public TestNoeud ( Object valeur, TestNoeud<E> g,
		   TestNoeud<E> d){
      element = (E) valeur;
      gauche = g;
      droit = d;
   }
 };