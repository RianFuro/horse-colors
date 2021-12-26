package sekelsta.horse_colors.entity.genetics;

import java.util.HashMap;
import net.minecraft.world.entity.AgeableMob;

public class FakeGeneticEntity implements IGeneticEntity {
    private Genome genome; 
    private String geneData;
    private boolean gender;
    private float motherSize;
    private int seed;

    public FakeGeneticEntity() {
         geneData = "";
    }

    @Override
    public Genome getGenome() {
        return genome;
    }

    @Override
    public String getGeneData() {
        return geneData;
    }

    @Override
    public void setGeneData(String genes) {
        this.geneData = genes;
    }

    @Override
    public int getSeed() {
        return seed;
    }

    @Override
    public void setSeed(int seed) {
        this.seed = seed;
    }

    @Override
    public java.util.Random getRand() {
        return new java.util.Random();
    }

    @Override
    public boolean isMale() {
        return gender;
    }

    @Override
    public void setMale(boolean gender) {
        this.gender = gender;
    }

    @Override
    public int getRebreedTicks() {
        return 0;
    }

    @Override
    public int getBirthAge() {
        return 0;
    }

    @Override
    public int getTrueAge() {
        return 0;
    }

    @Override
    public boolean setPregnantWith(AgeableMob child, AgeableMob otherParent) {
        return false;
    }

    @Override
    public float getMotherSize() {
        return this.motherSize;
    }

    @Override
    public void setMotherSize(float size) {
        this.motherSize = size;
    }
}
