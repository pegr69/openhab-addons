/**
 * Copyright (c) 2010-2021 Contributors to the openHAB project
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
package org.openhab.binding.wermasignaltower.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ThingTypeUID;

/**
 * The {@link WermaSignalTowerBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Peter Grape - Initial contribution
 */
@NonNullByDefault
public class WermaSignalTowerBindingConstants {

    private static final String BINDING_ID = "wermasignaltower";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_SIGNALTOWER = new ThingTypeUID(BINDING_ID, "signaltower");

    // List of all Channel ids
    public static final String CHANNEL_TIER1 = "tier1";
    public static final String CHANNEL_TIER2 = "tier2";
    public static final String CHANNEL_TIER3 = "tier3";
    public static final String CHANNEL_TIER4 = "tier4";
    public static final String CHANNEL_TIER5 = "tier5";

    public static final String CHANNEL_VERSION = "version";
    public static final String CHANNEL_NAME = "name";

    // Commands
    public static final String WRITEPREFIX = "WR";
    public static final String CONFIGSUFFIX = "S";
    public static final String READPREFIX = "RD";
    public static final String VERSIONPREFIX = "V";
    public static final String NAMEPREFIX = "N";

    // Values
    public static final String TIERSTATE_OFF = "0";
    public static final String TIERSTATE_ON = "1";
    public static final String TIERSTATE_FLASH1 = "2";
    public static final String TIERSTATE_FLASH2 = "3";
    public static final String TIERSTATE_IGNORE = "X";
}
