package logics.simplePrograms;

 class sampletest {
        private int a =10;
        public int getA ( )
        {
            return a ;
        }
        public void setA ( int a )
        {
            this. a =a ;
        }
    }
    class encapsulation {
         public static void main ( String [ ] args) {
             sampletest e = new sampletest();
            int y  = e.getA ( );
            System.out.println( y ) ;
            e.setA (123);
            System.out.println( e.getA() ) ;
            System.out.println( e.getA()) ;
        } }

