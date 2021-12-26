package sekelsta.horse_colors.breed.horse;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Map;

import sekelsta.horse_colors.breed.Breed;
import sekelsta.horse_colors.entity.genetics.EquineGenome.Gene;

public class QuarterHorse {
    public static Breed<Gene> breed = new Breed<>(Breed.load("quarter_horse_size"));

    static {
        breed.name = "quarter_horse";
        // Source for population:
        // https://academic.oup.com/jhered/article/105/2/148/790903
        breed.population = 2640000;
        breed.parent = MongolianHorse.breed;

        Map<Gene, List<Float>> GENES = breed.genes;

        // Source: https://onlinelibrary.wiley.com/doi/full/10.1111/jvim.15403#jvim15403-tbl-0002
        // Also: https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4608717/
        GENES.put(Gene.HMGA2, ImmutableList.of(
            1f,     // Wild type (G)
            1f      // Smaller ponies (A)
        ));

        // Source for color genes: http://grullablue.com/colors/qhcolors.htm
        // Archive link just in case:
        // https://web.archive.org/web/20200131035535/http://grullablue.com/colors/qhcolors.htm
        // From that, 7.06% of quarter horses are registered as gray which
        // works out to a gray allele frequency of 0.036
        GENES.put(Gene.gray, ImmutableList.of(
            0.964f,     // Non-gray
            1f          // Gray
        ));
        // All chestnut/sorrel based colors divided bu all non-gray makes 0.55%,
        // for an e allele frequency of 0.74
        GENES.put(Gene.extension, ImmutableList.of(
            0.74f,  // Red
            1f      // Black
        ));
        // After that, summing cremello + perlino + (buckskin + palomino) / 2
        // and dividing by total non-gray horses gives a cream allele frequency
        // of 0.078
        // Note smoky black is not a registration option
        // Arbitrarily picking 1/200 frequency for pearl
        // No snowdrop
        GENES.put(Gene.cream, ImmutableList.of(
            0.817f, // Non-cream
            0.817f,     // Snowdrop
            0.822f,     // Pearl
            0.9f,     // Cream
            1f      // MAPT minor
        ));
        // Dun allele frequency works out to about 0.042
        // Taking a guess on nd1 frequency
        GENES.put(Gene.dun, ImmutableList.of(
            0.94f,  // Non-dun 2
            0.958f, // Non-dun 1
            1f,     // Dun
            0f      // Dun unused
        ));
        // Roan frequency works out to about 0.05.
        // Not covered in the registration, there is still a very small chance
        // of sabino 1 (as well as frame overo and leopard complex)
        GENES.put(Gene.KIT, ImmutableList.of(
            0.65f,  // Wildtype
            0.70f,  // White boost
            0.74f,  // Markings1
            0.78f,  // Markings2
            0.82f,  // Markings3
            0.84f,  // Markings4
            0.85f,  // Markings5
            0.96f,  // W20
            0f,     // Rabicano / Unused
            0.948f,  // Flashy white
            0f,     // Unused
            0.948f, // Tobiano
            0.95f,  // Sabino1
            0.95f,  // Tobiano + W20
            1.0f,   // Roan
            1.0f    // Dominant white
        ));
        // For agouti, I'm looking at the number of black and brown horses
        // divided by (black + brown + bay), because there
        // isn't a category for brown with dun, roan, etc.
        // 13% black works out to a frequency of 0.36
        // 70% bay works out to a frequency of just under 0.48, but I'll
        // assume brown contains both seal brown and dark bay, and leave it
        // at 0.5.
        GENES.put(Gene.agouti, ImmutableList.of(
            0.36f,      // Black
            0.5f,       // Seal
            0.5f,       // Seal unused
            0.5f,       // Bay unused
            1f          // Bay
        ));
        // Occasionally quarter horses turn out to have frame overo
        GENES.put(Gene.frame, ImmutableList.of(
            0.996f, // Non-frame
            1f      // Frame
        ));
        // Occasionally quarter horses turn out to have leopard complex
        GENES.put(Gene.leopard, ImmutableList.of(
            0.996f,    // Non-leopard
            1f          // Leopard
        ));
        // SW1 can be found in quarter horses
        // Source: https://www.animalgenetics.us/Equine/Coat_Color/Splash.asp
        // (Also crop-outs)
        GENES.put(Gene.MITF, ImmutableList.of(
            0.01f,  // SW1
            0.01f,  // SW3
            0.0f,   // SW5
            1.0f    // Wildtype
        ));
        // Silver is rare
        // See https://vgl.ucdavis.edu/test/silver
        GENES.put(Gene.silver, ImmutableList.of(
            0.995f, // Non-silver
            1.0f    // Silver
        ));
        // Don't know if mealy is just rare or doesn't exist
        GENES.put(Gene.light_belly, ImmutableList.of(
            1f,     // Non-mealy
            1f      // Mealy
        ));

        // Rabicano exists but is rare
        GENES.put(Gene.rabicano, ImmutableList.of(
            0.999f, // No rabicano
            1f      // Rabicano
        ));
    }

    public static void init() {}
}
