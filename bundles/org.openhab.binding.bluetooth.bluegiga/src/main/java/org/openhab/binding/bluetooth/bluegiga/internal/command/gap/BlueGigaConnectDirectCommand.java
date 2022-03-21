/**
 * Copyright (c) 2010-2022 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.bluetooth.bluegiga.internal.command.gap;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.bluetooth.bluegiga.internal.BlueGigaCommand;
import org.openhab.binding.bluetooth.bluegiga.internal.enumeration.BluetoothAddressType;

/**
 * Class to implement the BlueGiga command <b>connectDirect</b>.
 * <p>
 * This command will start the GAP direct connection establishment procedure to a dedicated
 * Smart Bluetooth device. The module will enter a state where it continuously scans for the
 * connectable advertisement packets Bluetooth from the remote device which matches the
 * Bluetooth address gives as a parameter. Upon receiving the advertisement packet, the
 * module will send a connection request packet to the target device to imitate a Bluetooth
 * connection. A successful connection will bi indicated by a event. Status If the device is
 * configured to support more than one connection, the smallest connection interval which is
 * divisible by maximum_connections * 2.5ms will be selected. Thus, it is important to provide
 * minimum and maximum connection intervals so that such a connection interval is available
 * within the range. The connection establishment procedure can be cancelled with End
 * Procedure command.
 * <p>
 * This class provides methods for processing BlueGiga API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 * @author Pauli Anttila - Added message builder
 */
@NonNullByDefault
public class BlueGigaConnectDirectCommand extends BlueGigaCommand {
    public static int COMMAND_CLASS = 0x06;
    public static int COMMAND_METHOD = 0x03;

    private BlueGigaConnectDirectCommand(CommandBuilder builder) {
        this.address = builder.address;
        this.addrType = builder.addrType;
        this.connIntervalMin = builder.connIntervalMin;
        this.connIntervalMax = builder.connIntervalMax;
        this.timeout = builder.timeout;
        this.latency = builder.latency;
    }

    /**
     * Bluetooth address of the target device.
     * <p>
     * BlueGiga API type is <i>bd_addr</i> - Java type is {@link String}
     */
    private String address;

    /**
     * see: Bluetooth Address Types.
     * <p>
     * BlueGiga API type is <i>BluetoothAddressType</i> - Java type is {@link BluetoothAddressType}
     */
    private BluetoothAddressType addrType;

    /**
     * Minimum Connection Interval (in units of 1.25ms). Range: 6 - 3200 The lowest possible
     * Connection Interval is 7.50ms and the largest is 4000ms.
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     */
    private int connIntervalMin;

    /**
     * Maximum Connection Interval (in units of 1.25ms). Range: 6 - 3200 Must be equal or bigger than
     * minimum Connection Interval.
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     */
    private int connIntervalMax;

    /**
     * Supervision Timeout (in units of 10ms). The Supervision Timeout defines how long the
     * devices can be out of range before the connection is closed. Range: 10 - 3200 Minimum time for
     * the Supervision Timeout is 100ms and maximum value is 32000ms. According to the
     * specification, the Supervision Timeout in milliseconds shall be larger than (1 + latency) *
     * conn_interval_max * 2, where conn_interval_max is given in milliseconds.
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     */
    private int timeout;

    /**
     * This parameter configures the slave latency. Slave latency defines how many connection
     * intervals a slave device can skip. Increasing slave latency will decrease the energy
     * consumption of the slave in scenarios where slave does not have data to send at every
     * connection interval. Range: 0 - 500 0 : Slave latency is disabled. Example: Connection
     * interval is 10ms and slave latency is 9: this means that the slave is allowed to communicate
     * every 100ms, but it can communicate every 10ms if needed.
     * <p>
     * BlueGiga API type is <i>uint16</i> - Java type is {@link int}
     */
    private int latency;

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(COMMAND_CLASS, COMMAND_METHOD);

        // Serialize the fields
        serializeAddress(address);
        serializeBluetoothAddressType(addrType);
        serializeUInt16(connIntervalMin);
        serializeUInt16(connIntervalMax);
        serializeUInt16(timeout);
        serializeUInt16(latency);

        return getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BlueGigaConnectDirectCommand [address=");
        builder.append(address);
        builder.append(", addrType=");
        builder.append(addrType);
        builder.append(", connIntervalMin=");
        builder.append(connIntervalMin);
        builder.append(", connIntervalMax=");
        builder.append(connIntervalMax);
        builder.append(", timeout=");
        builder.append(timeout);
        builder.append(", latency=");
        builder.append(latency);
        builder.append(']');
        return builder.toString();
    }

    public static class CommandBuilder {
        private String address = "";
        private BluetoothAddressType addrType = BluetoothAddressType.UNKNOWN;
        private int connIntervalMin;
        private int connIntervalMax;
        private int timeout;
        private int latency;

        /**
         * Bluetooth address of the target device.
         *
         * @param address the address to set as {@link String}
         */
        public CommandBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * see: Bluetooth Address Types.
         *
         * @param addrType the addrType to set as {@link BluetoothAddressType}
         */
        public CommandBuilder withAddrType(BluetoothAddressType addrType) {
            this.addrType = addrType;
            return this;
        }

        /**
         * Minimum Connection Interval (in units of 1.25ms). Range: 6 - 3200 The lowest possible
         * Connection Interval is 7.50ms and the largest is 4000ms.
         *
         * @param connIntervalMin the connIntervalMin to set as {@link int}
         */
        public CommandBuilder withConnIntervalMin(int connIntervalMin) {
            this.connIntervalMin = connIntervalMin;
            return this;
        }

        /**
         * Maximum Connection Interval (in units of 1.25ms). Range: 6 - 3200 Must be equal or bigger than
         * minimum Connection Interval.
         *
         * @param connIntervalMax the connIntervalMax to set as {@link int}
         */
        public CommandBuilder withConnIntervalMax(int connIntervalMax) {
            this.connIntervalMax = connIntervalMax;
            return this;
        }

        /**
         * Supervision Timeout (in units of 10ms). The Supervision Timeout defines how long the
         * devices can be out of range before the connection is closed. Range: 10 - 3200 Minimum time for
         * the Supervision Timeout is 100ms and maximum value is 32000ms. According to the
         * specification, the Supervision Timeout in milliseconds shall be larger than (1 + latency) *
         * conn_interval_max * 2, where conn_interval_max is given in milliseconds.
         *
         * @param timeout the timeout to set as {@link int}
         */
        public CommandBuilder withTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * This parameter configures the slave latency. Slave latency defines how many connection
         * intervals a slave device can skip. Increasing slave latency will decrease the energy
         * consumption of the slave in scenarios where slave does not have data to send at every
         * connection interval. Range: 0 - 500 0 : Slave latency is disabled. Example: Connection
         * interval is 10ms and slave latency is 9: this means that the slave is allowed to communicate
         * every 100ms, but it can communicate every 10ms if needed.
         *
         * @param latency the latency to set as {@link int}
         */
        public CommandBuilder withLatency(int latency) {
            this.latency = latency;
            return this;
        }

        public BlueGigaConnectDirectCommand build() {
            return new BlueGigaConnectDirectCommand(this);
        }
    }
}
