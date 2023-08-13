package de.ait;

/**
 * @author Andrej Reutow
 * created on 12.08.2023
 */
public class Coffee {

    private String type;
    private int milk;
    private int sugar;

    public Coffee(Builder builder) {
        this.type = builder.type;
        this.milk = builder.milk;
        this.sugar = builder.sugar;
    }

    public Coffee() {
    }

    public Coffee(String type, int milk, int sugar) {
        this.type = type;
        this.milk = milk;
        this.sugar = sugar;
    }


    public String getType() {
        return type;
    }


    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coffee{");
        sb.append("type='").append(type).append('\'');
        sb.append(", milk=").append(milk);
        sb.append(", sugar=").append(sugar);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {
        private String type;
        private int milk;
        private int sugar;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder milk(int milk) {
            this.milk = milk;
            return this;
        }

        public Builder sugar(String sugar) {
            this.sugar = Integer.parseInt(sugar);
            return this;
        }

        public Coffee build() {
            if (this.type == null){
                throw new IllegalArgumentException("Тип кофе не может быть null");
            }
            return new Coffee(this);
        }
    }
}
