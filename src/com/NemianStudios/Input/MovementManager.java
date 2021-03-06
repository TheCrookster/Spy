package com.NemianStudios.Input;

import com.NemianStudios.Display.Camera;
import info.rockscode.util.Vector3f;


import java.util.Vector;

public class MovementManager {


    public static class Command {

        Vector<Integer> commands = new Vector<Integer>();

        public static final int NONE = 0;
        public static final int MOVECAMERADIRECTION = 1;
        public static final int MOVECAMERAPOSTION = 2;

        public static int Type = NONE;
        public static Vector3f pos = new Vector3f(0, 0, 0);

        public static double yaw = 0;
        public static double pitch = 0;

        public void Move(int sideways, int up, int forward) {
            pos.x += sideways;
            pos.y += up;
            pos.z += forward;
        }

        public void pan(double var) {
            yaw += var;
        }

        public void tilt(double var) {
            pitch += var;
        }

        public double getYaw() {
            return yaw;
        }

        public double getPitch() {
            return pitch;
        }

        public Vector3f getPos() {
            return pos;
        }

        public void addcommand(int command) {
            commands.add(command);
        }
    }

    private Vector<Command> commandList = new Vector<Command>();

    public void update(Camera camera) {
        for (int i = 0; i < commandList.size(); i++) {
            Command command = commandList.get(i);
            for (int commandtype : command.commands) {
                switch (commandtype) {
                    case Command.MOVECAMERADIRECTION:
                        camera.pan(command.getYaw());
                        camera.tilt(command.getPitch());
                        break;
                    case Command.MOVECAMERAPOSTION:
                        camera.MoveCamera(command.getPos());
                        break;
                }
            }
            commandList.remove(command);
        }
    }

    public void addtocommandlist(Command command) {
        commandList.add(command);
    }
}
