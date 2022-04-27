package ie.tudublin;

import processing.data.TableRow;

public class Nematode {

    public String name;
    public int length;
    public int limbs;
    public String gender;
    public int eyes;


    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public Nematode(String name, int length, int limbs, String gender, int eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"), 
            tr.getInt("length"), 
            tr.getInt("limbs"), 
            tr.getString("gender"), 
            tr.getInt("eyes")
            );
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLimbs() {
        return limbs;
    }

    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEyes() {
        return eyes;
    }

    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser pa)
    {   
        //Sets the position of the body at the center of the screen
        int x = pa.width/2;
        int y = pa.height/2;

        //Generating the tail
        {
            switch(gender)
            {
                case "f":
                {
                    pa.circle(x, y, 20);
                    pa.fill(0);
                    pa.noFill();
                }
                case "m":
                {
                    pa.line(x - 50, -1, y - 50, 10);
                    pa.circle(x, y, 20);
                    pa.fill(0);
                    pa.noFill();
                }
                case "h":
                {
                    pa.circle(x, y, 20);
                    pa.fill(0);
                    pa.noFill();

                    pa.line(x - 50, -1, y - 50, 10);
                    pa.circle(x, y, 20);
                    pa.fill(0);
                    pa.noFill();
                }
                default:
                {

                }
            }
        }


        //loop to generate the rings
        for(int i = 0; i < length; i++)
        {
            pa.circle(x, y + (i * 50), 50);
            pa.fill(0);
            pa.noFill();

            if(limbs > 0)
            {
                for(int j = i; j < limbs; j++)
                {
                    pa.line(50, y + (j * 50), 60, y + (j * 50));
                }

                //to locate the last position of the ring which is the top
            }
            
            

        } 
        
        //Generating the eyes
        if(eyes == 1)
        {
            int eye_tip = ((length-1) * 50);
            pa.line((eye_tip + 10), (eye_tip + 50), (eye_tip + 25), (eye_tip + 25));
            pa.circle(x, y, 20);
            pa.fill(0);
            pa.noFill();

            pa.line((eye_tip - 10), (eye_tip + 50), (eye_tip - 25), (eye_tip + 25));
            pa.circle(x, y, 20);
            pa.fill(0);
            pa.noFill();
        }

    }


    
}
