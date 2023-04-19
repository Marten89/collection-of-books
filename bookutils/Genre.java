package bookutils;

import java.io.Serializable;

/**
 * Represents genres for books. Implements
 * interface Serializable.
 */
public enum Genre implements Serializable {
    DRAMA, ROMANCE, CRIME, HORROR, FANTASY, SCIENCE_FICTION, COOKBOOK, NON_FICTION;
}
