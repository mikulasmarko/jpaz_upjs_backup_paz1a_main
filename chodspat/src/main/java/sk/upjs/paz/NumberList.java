public class NumberList {
        private int[] number;
        public NumberList() {
            this.number = new int[0];

        }

        public NumberList(int[] numbers) {
            this.number = new int[numbers.length];
            System.arraycopy(numbers, 0, number, 0, numbers.length);

        }

        public NumberList(NumberList numberList) {
            
            this.setNumber(numberList.getNumber());

        }

        public int get(int index) {
            return 0;
        }

        public void set(int index, int value) {
        }

        public void add(int value) {
            int[] pomocne = new int[number.length + 1];
            for (int i = 0; i < number.length; i++){
                pomocne[i] = number[i];
    
            }
            pomocne[pomocne.length - 1] = value;
            number = pomocne;
        }

        public int size() {
            return number.length;
        }

        public void clear() {
            number = new int[0];
        }

        public int remove(int index) {
            return 0;
        }

        @Override
        public String toString() {
            return Arrays.toString(number);
        }
        
        public int[] getNumber() {
            return number;
        }

        public void setNumber(int[] number) {
            this.number = number;
        }
        
        
}