package spil;

    public class Account {

        private int balance;

        public Account(int balance) {
            this.balance = balance;
        }

        public void addBalance(int amount){
            setBalance(getBalance()+amount);
            if (getBalance()<0) {
                setBalance(0);
            }
        }

        public void withdraw(int amount) {
            setBalance(getBalance()-amount);
            if (getBalance()<0) {
                setBalance(0);
            }
        }

        public void deposit(int amount) {
            setBalance(getBalance()+amount);
            if (getBalance()<0) {
                setBalance(0);
            }
        }

        public int getBalance() {
            return balance;
        }
        public void setBalance(int balance) {
            this.balance = balance;
        }


    }