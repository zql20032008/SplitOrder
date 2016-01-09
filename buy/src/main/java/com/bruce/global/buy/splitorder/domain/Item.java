package com.bruce.global.buy.splitorder.domain;

/**
 * @author bruce.zql
 * 物品
 *
 */
public class Item implements Comparable<Item>{

    private Long   id;

    private String name;

    private int    size;
    
    

    public Item(String name, int size) {
        super();
        this.name = name;
        this.size = size;
    }

    public Item(Long id, String name, int size) {
        super();
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + size;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (size != other.size)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", size=" + size + "]";
    }
    
    /**
     * Item排序会使用到
     * @param item
     * @return
     */
    public int compareTo(Item item) {
        
        if(this.getSize()==item.getSize()){
            return 0;
        }
        else if(this.getSize()<item.getSize()){
            return -1;
        }
        return 1;
        
    }
    
    

}