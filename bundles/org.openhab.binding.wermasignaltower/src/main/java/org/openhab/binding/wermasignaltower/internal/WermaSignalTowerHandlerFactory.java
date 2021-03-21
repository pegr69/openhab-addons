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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.openhab.core.io.transport.serial.SerialPortManager;
import org.openhab.core.thing.Thing;
import org.openhab.core.thing.ThingTypeUID;
import org.openhab.core.thing.binding.BaseThingHandlerFactory;
import org.openhab.core.thing.binding.ThingHandler;
import org.openhab.core.thing.binding.ThingHandlerFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The {@link WermaSignalTowerHandlerFactory} is responsible for creating things and thing
 * handlers.
 *
 * @author Peter Grape - Initial contribution
 */
@NonNullByDefault
@Component(configurationPid = "binding.wermasignaltower", service = ThingHandlerFactory.class)
public class WermaSignalTowerHandlerFactory extends BaseThingHandlerFactory {

    private static final Set<ThingTypeUID> SUPPORTED_THING_TYPES_UIDS = Set
            .of(WermaSignalTowerBindingConstants.THING_TYPE_SIGNALTOWER);

    @Override
    public boolean supportsThingType(ThingTypeUID thingTypeUID) {
        return SUPPORTED_THING_TYPES_UIDS.contains(thingTypeUID);
    }

    private SerialPortManager serialPortManager;

    @Activate
    public WermaSignalTowerHandlerFactory(@Reference final SerialPortManager serialPortManager) {
        this.serialPortManager = serialPortManager;
    }

    @Override
    protected @Nullable ThingHandler createHandler(Thing thing) {
        ThingTypeUID thingTypeUID = thing.getThingTypeUID();

        if (WermaSignalTowerBindingConstants.THING_TYPE_SIGNALTOWER.equals(thingTypeUID)) {
            return new WermaSignalTowerHandler(thing);
        }

        return null;
    }
}
