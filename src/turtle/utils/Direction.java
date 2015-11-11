package turtle.utils;

public enum Direction {
  NORTH {
    @Override
    public Direction rotate(Rotation rotation) {return (rotation == Rotation.CLOCKWISE) ? NORTHEAST : NORTHWEST; }
  },
  SOUTH {
    @Override
    public Direction rotate(Rotation rotation) {
      return (rotation == Rotation.CLOCKWISE) ? SOUTHWEST : SOUTHEAST;
    }
  },
  EAST {
    @Override
    public Direction rotate(Rotation rotation) {
      return (rotation == Rotation.CLOCKWISE) ? SOUTHEAST : NORTHEAST;
    }
  },
  WEST {
    @Override
    public Direction rotate(Rotation rotation) {
      return (rotation == Rotation.CLOCKWISE) ? NORTHWEST : SOUTHWEST;
    }
  },
  NORTHWEST {
    @Override
    public Direction rotate(Rotation rotation) {
      return (rotation == Rotation.CLOCKWISE) ? NORTH : WEST;
    }
  },
  SOUTHWEST {
    @Override
    public Direction rotate(Rotation rotation) {
      return (rotation == Rotation.CLOCKWISE) ? WEST : SOUTH;
    }
  },
  NORTHEAST {
    @Override
    public Direction rotate(Rotation rotation) { return (rotation == Rotation.CLOCKWISE) ? EAST : NORTH; }
  },
  SOUTHEAST {
    @Override
    public Direction rotate(Rotation rotation) {
      return (rotation == Rotation.CLOCKWISE) ? SOUTH : EAST;
    }
  };

  public abstract Direction rotate(Rotation rotation);

}

