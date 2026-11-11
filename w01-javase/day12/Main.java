package day12;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. 创建设备集合
        ArrayList<Device> devices = new ArrayList<>();

        // 2. 添加两台设备
        devices.add(new Device(1001L, "数控机床", "一号车间", "正常运行"));
        devices.add(new Device(1002L, "激光切割机", "二号车间", "待维修"));

        // 3. 循环打印所有设备（println 会自动调用 toString）
        for (Device device : devices) {
            System.out.println(device);
        }
    }
}
