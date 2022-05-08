package cz.muni.var4astro.dao;

import cz.muni.var4astro.dto.ObjectFluxCount;
import cz.muni.var4astro.dto.SpaceObject;

import java.util.List;

/**
 * The interface Upload error messages dao, data access object for the space_object entity.
 */
public interface SpaceObjectDao {

    /**
     * Build an SQL query based on the paramaters that were
     * given by the user in the search form and return objects matching
     * the search paramaters along with number of corresponding fluxes for each object.
     *
     * @param RA       the given right ascension
     * @param dec      the given declination
     * @param radius   the given radius
     * @param name     the given name of the object
     * @param minMag   the bottom magnitude boundary
     * @param maxMag   the upper magnitude boundary
     * @param catalog  the catalog
     * @param objectId the catalog id
     * @return list of objects fullfiling the search parameters
     * along with number of corresponding fluxes for each object
     */
    List<ObjectFluxCount> queryObjects(String RA, String dec, String radius,
                                       String name, String minMag,
                                       String maxMag, String catalog, String objectId);

    /**
     * Persist space object to the database.
     *
     * @param catalogId  the catalog id
     * @param name       the name
     * @param catalog    the catalog
     * @param strDec     the str declination
     * @param strRec     the str right ascension
     * @param catalogDec the catalog declination
     * @param catalogRec the catalog right ascension
     * @param catalogMag the catalog magnitude
     * @return the generated id
     */
    long saveObject(String catalogId, String name, String catalog, String strDec, String strRec,
                    Float catalogDec, Float catalogRec, Float catalogMag);

    /**
     * Gets catalogues used in the database.
     *
     * @return the List of the catalogues sued
     */
    List<String> getAvailableCatalogues();

    /**
     * Gets space object by id.
     *
     * @param id the id
     * @return the space object
     */
    SpaceObject getSpaceObjectById(Long id);

    /**
     * Gets a statistical estimate of the number of space_objects in the database
     *
     * @return the estimate
     */
    Long getNumberOfObjectsEstimate();
}
