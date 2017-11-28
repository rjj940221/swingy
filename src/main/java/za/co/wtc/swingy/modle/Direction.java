package za.co.wtc.swingy.modle;

import javax.validation.constraints.NotNull;

public enum Direction {
    None{
        @Override
        public Direction oposite() {
            return None;
        }
    },
    North{
        @Override
        public Direction oposite() {
            return South;
        }
    },
    East{
        @Override
        public Direction oposite() {
            return West;
        }
    },
    South{
        @Override
        public Direction oposite() {
            return North;
        }
    },
    West{
        @Override
        public Direction oposite() {
            return East;
        }
    };

    @NotNull
    public abstract Direction oposite();
}
