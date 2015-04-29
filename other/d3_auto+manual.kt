package d3
/*
object D3 {

    native
    public trait Selectors {
        //    public var select: {
        //            /**
        //            * Selects the first element that matches the specified selector string
        //            *
        //            * @param selector Selection String to match
        //            */
        //            (selector: string): Selection;
        //            /**
        //            * Selects the specified node
        //            *
        //            * @param element Node element to select
        //            */
        //            (element: EventTarget): Selection;
        //        }
        //    public var selectAll: {
        //            /**
        //            * Selects all elements that match the specified selector
        //            *
        //            * @param selector Selection String to match
        //            */
        //            (selector: string): Selection;
        //            /**
        //            * Selects the specified array of elements
        //            *
        //            * @param elements Array of node elements to select
        //            */
        //            (elements: EventTarget[]): Selection;
        //        }
    }
    native
    public trait Event {
        public var dx: Number
        public var dy: Number
        public var clientX: Number
        public var clientY: Number
        public var translate: Array<Number>
        public var scale: Number
        public var sourceEvent: Event
        public var x: Number
        public var y: Number
        public var keyCode: Number
        public var altKey: Any
    }
    native
    public trait Base : Selectors {
        public var behavior: Behavior.Behavior
        public var event: Event
        public fun ascending<T>(a: T, b: T): Number
        public fun descending<T>(a: T, b: T): Number
        public fun min<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        public fun max<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        public fun extent<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Array<Number>
        public fun sum<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        public fun mean<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        public fun median<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        public var quantile: (arr: Array<Number>, p: Number) -> Number
        public fun bisect<T>(arr: Array<T>, x: T, low: Number? = null, high: Number? = null): Number
        public fun bisectLeft<T>(arr: Array<T>, x: T, low: Number? = null, high: Number? = null): Number
        public fun bisectRight<T>(arr: Array<T>, x: T, low: Number? = null, high: Number? = null): Number
        public fun bisector(accessor: (data: Any, index: Number) -> Any): Any
        public fun shuffle<T>(arr: Array<T>): Array<T>
        public fun permute(arr: Array<Any>, indexes: Array<Any>): Array<Any>
        public fun zip(vararg arrs: Any): Array<Any>
        public fun transform(definition: String): Any
        public fun transpose(matrix: Array<Any>): Array<Any>
        public fun keys(map: Array<Any>): Array<Any>
        public fun values(map: Array<Any>): Array<Any>
        public fun entries(map: Array<Any>): Array<Any>
        public fun merge(vararg map: Any): Array<Any>
//        public var range: {
//        /**
//         * Generate a range of numeric values from 0.
//         *
//         * @param stop Value to generate the range to
//         * @param step Step between each value
//         */
//        (stop: number, step?: number): number[];
//        /**
//         * Generate a range of numeric values.
//         *
//         * @param start Value to start
//         * @param stop Value to generate the range to
//         * @param step Step between each value
//         */
//        (start: number, stop?: number, step?: number): number[];
//    }
        public fun nest(): Nest
//    public var xhr: {
//    /**
//     * Creates an asynchronous request for specified url
//     *
//     * @param url Url to request
//     * @param callback Function to invoke when resource is loaded or the request fails
//     */
//    (url: string, callback?: (xhr: XMLHttpRequest) => void ): Xhr;
//    /**
//     * Creates an asynchronous request for specified url
//     *
//     * @param url Url to request
//     * @param mime MIME type to request
//     * @param callback Function to invoke when resource is loaded or the request fails
//     */
//    (url: string, mime: string, callback?: (xhr: XMLHttpRequest) => void ): Xhr;
//    }
//public var text: {
///**
// * Request a text file
// *
// * @param url Url to request
// * @param callback Function to invoke when resource is loaded or the request fails
// */
//(url: string, callback?: (response: string) => void ): Xhr;
///**
// * Request a text file
// *
// * @param url Url to request
// * @param mime MIME type to request
// * @param callback Function to invoke when resource is loaded or the request fails
// */
//(url: string, mime: string, callback?: (response: string) => void ): Xhr;
//}
public var json: (url: String, callback: ((error: Any, data: Any) -> Unit)? = null) -> Xhr
//public var xml: {
///**
// * Request an HTML document fragment.
// *
// * @param url Url to request
// * @param callback Function to invoke when resource is loaded or the request fails
// */
//(url: string, callback?: (response: Document) => void ): Xhr;
///**
// * Request an HTML document fragment.
// *
// * @param url Url to request
// * @param mime MIME type to request
// * @param callback Function to invoke when resource is loaded or the request fails
// */
//(url: string, mime: string, callback?: (response: Document) => void ): Xhr;
//}
public var html: (url: String, callback: ((response: DocumentFragment) -> Unit)? = null) -> Xhr
public var csv: Dsv
public var tsv: Dsv
public var time: Time.Time
public var scale: Scale.ScaleBase
public var interpolate: Transition.BaseInterpolate
public var interpolateNumber: Transition.BaseInterpolate
public var interpolateRound: Transition.BaseInterpolate
public var interpolateString: Transition.BaseInterpolate
public var interpolateRgb: Transition.BaseInterpolate
public var interpolateHsl: Transition.BaseInterpolate
public var interpolateHcl: Transition.BaseInterpolate
public var interpolateLab: Transition.BaseInterpolate
public var interpolateArray: Transition.BaseInterpolate
public var interpolateObject: Transition.BaseInterpolate
public var interpolateTransform: Transition.BaseInterpolate
public var interpolators: Array<Transition.InterpolateFactory>
public var layout: Layout.Layout
public var svg: Svg.Svg
public var random: Random
public fun format(specifier: String): (value: Number) -> String
public fun formatPrefix(value: Number, precision: Number? = null): MetricPrefix
public var version: String
public fun selection(): Selection
//public var ns: {
///**
// * The map of registered namespace prefixes
// */
//prefix: {
//svg: string;
//xhtml: string;
//xlink: string;
//xml: string;
//xmlns: string;
//};
///**
// * Qualifies the specified name
// */
//qualify(name: string): { space: string; local: string; };
//}
public var ease: (`type`: String, vararg arrs: Any) -> D3.Transition.Transition
//public var rgb: {
///**
// * Constructs a new RGB color with the specified r, g and b channel values
// */
//(r: number, g: number, b: number): D3.Color.RGBColor;
///**
// * Constructs a new RGB color by parsing the specified color string
// */
//(color: string): D3.Color.RGBColor;
//}
//public var hcl: {
///**
// * Constructs a new HCL color.
// */
//(h: number, c: number, l: number): Color.HCLColor;
///**
// * Constructs a new HCL color by parsing the specified color string
// */
//(color: string): Color.HCLColor;
//}
//public var hsl: {
///**
// * Constructs a new HSL color with the specified hue h, saturation s and lightness l
// */
//(h: number, s: number, l: number): Color.HSLColor;
///**
// * Constructs a new HSL color by parsing the specified color string
// */
//(color: string): Color.HSLColor;
//}
//public var lab: {
///**
// * Constructs a new LAB color.
// */
//(l: number, a: number, b: number): Color.LABColor;
///**
// * Constructs a new LAB color by parsing the specified color string
// */
//(color: string): Color.LABColor;
//}
public var geo: Geo.Geo
public var geom: Geom.Geom
public fun mouse(container: Any): Array<Number>
public fun touches(container: Any): Array<Number>
public fun functor<R, T>(value: (p: R) -> T): (p: R) -> T
public fun functor<T>(value: T): (p: Any) -> T
public fun map(`object`: Any? = null): Map
public fun set(array: Array<Any>? = null): Set
public fun dispatch(vararg types: String): Dispatch
public fun rebind(target: Any, source: Any, vararg names: Any): Any
public fun requote(str: String): String
//public var timer: {
//(funct: () => boolean, delay?: number, mark?: number): void;
//flush(): void;
//}

public fun transition(): Transition.Transition
public fun round(x: Number, n: Number): Number
}
native
public trait Dispatch {
    public fun get(event: String): Any
    public fun set(event: String, value: Any)
//    public var on: {
//    (type: string): any;
//    (type: string, listener: any): any;
//}

}
native
public trait MetricPrefix {
    public var scale: (d: Number) -> Number
    public var symbol: String
}
native
public trait Xhr {
//    public var header: {
//    /**
//     * Get the value of specified request header
//     *
//     * @param name Name of header to get the value for
//     */
//    (name: string): string;
//    /**
//     * Set the value of specified request header
//     *
//     * @param name Name of header to set the value for
//     * @param value Value to set the header to
//     */
//    (name: string, value: string): Xhr;
//}
//public var mimeType: {
///**
// * Get the current MIME Type
// */
//(): string;
///**
// * Set the MIME Type for the request
// *
// * @param type The MIME type for the request
// */
//(type: string): Xhr;
//}
//public var response: {
///**
// * Get function used to map the response to the associated data value
// */
//(): (xhr: XMLHttpRequest) => any;
///**
// * Set function used to map the response to the associated data value
// *
// * @param value The function used to map the response to a data value
// */
//(value: (xhr: XMLHttpRequest) => any): Xhr;
//}
public fun get(callback: ((xhr: XMLHttpRequest) -> Unit)? = null): Xhr
//public var post: {
///**
// * Issue the request using the POST method
// *
// * @param callback Function to invoke on completion of request
// */
//(callback?: (xhr: XMLHttpRequest) => void ): Xhr;
///**
// * Issue the request using the POST method
// *
// * @param data Data to post back in the request
// * @param callback Function to invoke on completion of request
// */
//(data: any, callback?: (xhr: XMLHttpRequest) => void ): Xhr;
//}
//public var send: {
///**
// * Issues this request using the specified method
// *
// * @param method Method to use to make the request
// * @param callback Function to invoke on completion of request
// */
//(method: string, callback?: (xhr: XMLHttpRequest) => void ): Xhr;
///**
// * Issues this request using the specified method
// *
// * @param method Method to use to make the request
// * @param data Data to post back in the request
// * @param callback Function to invoke on completion of request
// */
//(method: string, data: any, callback?: (xhr: XMLHttpRequest) => void ): Xhr;
//}
public fun abort(): Xhr
public var on: (`type`: String, listener: (data: Any, index: Number? = null) -> Any) -> Xhr
}
native
public trait Dsv {
    public fun invoke(url: String, callback: ((error: Any, response: Array<Any>) -> Unit)? = null): Xhr
    public fun parse(string: String): Array<Any>
    public fun parseRows(string: String, accessor: (row: Array<Any>, index: Number) -> Any): Any
    public fun format(rows: Array<Any>): String
}
native
public trait Selection : Selectors, Array<Any>  {
    attr : {
public fun invoke(name: String): String   ;
public fun invoke(name: String, value: Any): Selection   ;
public fun invoke(name: String, valueFunction: (data: Any, index: Number) -> Any): Selection   ;
public fun invoke(attrValueMap: Any): Selection   ; } ; classed : {
public fun invoke(name: String): String   ;
public fun invoke(name: String, value: Any): Selection   ;
public fun invoke(name: String, valueFunction: (data: Any, index: Number) -> Any): Selection   ; } ; style : {
public fun invoke(name: String): String   ;
public fun invoke(name: String, value: Any, priority: String? = null): Selection   ;
public fun invoke(name: String, valueFunction: (data: Any, index: Number) -> Any, priority: String? = null): Selection   ; } ; property : {
public fun invoke(name: String): Unit   ;
public fun invoke(name: String, value: Any): Selection   ;
public fun invoke(name: String, valueFunction: (data: Any, index: Number) -> Any): Selection   ; } ; text : {
public fun invoke(): String   ;
public fun invoke(value: Any): Selection   ;
public fun invoke(valueFunction: (data: Any, index: Number) -> Any): Selection   ; } ; html : {
public fun invoke(): String   ;
public fun invoke(value: Any): Selection   ;
public fun invoke(valueFunction: (data: Any, index: Number) -> Any): Selection   ; } ; append :
public fun invoke(name: String) => Selection ; insert :
public fun invoke(name: String, before: String) => Selection ; remove :
public fun invoke() => Selection ; data : {
public fun invoke(values: (data: Any, index: Number? = null) -> Array<Any>, key: ((data: Any, index: Number? = null) -> String)? = null): UpdateSelection   ;
public fun invoke(values: Array<Any>, key: ((data: Any, index: Number? = null) -> String)? = null): UpdateSelection   ; } ; datum : {
public fun invoke(values: (data: Any, index: Number) -> Any): UpdateSelection   ;
public fun invoke(values: Any): UpdateSelection   ; } ; filter : {
public fun invoke(filter: (data: Any, index: Number) -> Boolean, thisArg: Any? = null): UpdateSelection   ; } ; call (callback public
fun invoke(selection: Selection) => Unit  )  Selection ; each (eachFunction public
fun invoke(data: Any, index: Number) => any )  Selection ; on : {
public fun invoke(`type`: String): (data: Any, index: Number) -> Any   ;
public fun invoke(`type`: String, listener: (data: Any, index: Number) -> Any, capture: Boolean? = null): Selection   ; } ; transition ()  Transition . Transition ; sort<T> (comparator ?  :
public fun invoke(a: T, b: T) => number )  Selection ; order :
public fun invoke() => Selection ; node :
public fun invoke() => Element ; } native
public trait EnterSelection {
    public var append: (name: String) -> Selection
    public var insert: (name: String, before: String) -> Selection
    public var select: (selector: String) -> Selection
    public var empty: () -> Boolean
    public var node: () -> Element
}
native
public trait UpdateSelection : Selection {
    public var enter: () -> EnterSelection
    public var update: () -> Selection
    public var exit: () -> Selection
}
native
public trait NestKeyValue {
    public var key: String
    public var values: Any
}
native
public trait Nest {
    public fun key(keyFunction: (data: Any, index: Number) -> String): Nest
    public fun sortKeys(comparator: (d1: Any, d2: Any) -> Number): Nest
    public fun sortValues(comparator: (d1: Any, d2: Any) -> Number): Nest
    public fun rollup(rollupFunction: (data: Any, index: Number) -> Any): Nest
    public fun map(values: Array<Any>): Any
    public fun entries(values: Array<Any>): Array<NestKeyValue>
}
native
public trait Map {
    public fun has(key: String): Boolean
    public fun get(key: String): Any
    public fun set<T>(key: String, value: T): T
    public fun remove(key: String): Boolean
    public fun keys(): Array<String>
    public fun values(): Array<Any>
    public fun entries(): Array<Any>
    public fun forEach(func: (key: String, value: Any) -> Unit): Unit
}
native
public trait Set {
    public fun has(value: Any): Boolean
    public fun Add(value: Any): Any
    public fun remove(value: Any): Boolean
    public fun values(): Array<Any>
    public fun forEach(func: (value: Any) -> Unit): Unit
}
native
public trait Random {
    public fun normal(mean: Number? = null, deviation: Number? = null): () -> Number
    public fun logNormal(mean: Number? = null, deviation: Number? = null): () -> Number
    public fun irwinHall(count: Number): () -> Number
}

object Transition {

    native
    public trait Transition {
        public var duration: {
        (duration: number): Transition;
        (duration: (data: any, index: number) => any): Transition;
    }
    public var delay: {
    (delay: number): Transition;
    (delay: (data: any, index: number) => any): Transition;
}
public var attr: {
(name: string): string;
(name: string, value: any): Transition;
(name: string, valueFunction: (data: any, index: number) => any): Transition;
(attrValueMap : any): Transition;
}
public var style: {
(name: string): string;
(name: string, value: any, priority?: string): Transition;
(name: string, valueFunction: (data: any, index: number) => any, priority?: string): Transition;
}
public fun call(callback: (selection: Selection) -> Unit): Transition
public var select: {
/**
 * Selects the first element that matches the specified selector string
 *
 * @param selector Selection String to match
 */
(selector: string): Transition;
/**
 * Selects the specified node
 *
 * @param element Node element to select
 */
(element: EventTarget): Transition;
}
public var selectAll: {
/**
 * Selects all elements that match the specified selector
 *
 * @param selector Selection String to match
 */
(selector: string): Transition;
/**
 * Selects the specified array of elements
 *
 * @param elements Array of node elements to select
 */
(elements: EventTarget[]): Transition;
}

public var each: (`type`: String? = null, eachFunction: ((data: Any, index: Number) -> Any)? = null) -> Transition
public var transition: () -> Transition
public var ease: (value: String, vararg arrs: Any) -> Transition
public fun attrTween(name: String, tween: (d: Any, i: Number, a: Any) -> BaseInterpolate): Transition
public fun styleTween(name: String, tween: (d: Any, i: Number, a: Any) -> BaseInterpolate, priority: String? = null): Transition
public var text: {
(text: string): Transition;
(text: (d: any, i: number) => string): Transition;
}

public fun tween(name: String, factory: InterpolateFactory): Transition
public var filter: {
(selector: string): Transition;
(selector: (data: any, index: number) => boolean): Transition;
}
public fun remove(): Transition
}
native
public trait InterpolateFactory {
    public fun invoke(a: Any? = null, b: Any? = null): BaseInterpolate
}
native
public trait BaseInterpolate {
    public fun invoke(a: Any, b: Any? = null): Any
}
native
public trait Interpolate {
    public fun invoke(t: Any): Any
}
}

object Time {

    native
    public trait Time {
        public var second: Interval
        public var minute: Interval
        public var hour: Interval
        public var day: Interval
        public var week: Interval
        public var sunday: Interval
        public var monday: Interval
        public var tuesday: Interval
        public var wednesday: Interval
        public var thursday: Interval
        public var friday: Interval
        public var saturday: Interval
        public var month: Interval
        public var year: Interval
        public var seconds: Range
        public var minutes: Range
        public var hours: Range
        public var days: Range
        public var weeks: Range
        public var months: Range
        public var years: Range
        public var sundays: Range
        public var mondays: Range
        public var tuesdays: Range
        public var wednesdays: Range
        public var thursdays: Range
        public var fridays: Range
        public var saturdays: Range
        public var format: {

        (specifier: string): TimeFormat;
        utc: (specifier: string) => TimeFormat;
        iso: TimeFormat;
    }
    public fun scale(): Scale.TimeScale
}
native
public trait Range {
    public fun invoke(start: Date, end: Date, step: Number? = null): Array<Date>
}
native
public trait Interval {
    public fun invoke(date: Date): Date
    public var floor: (date: Date) -> Date
    public var round: (date: Date) -> Date
    public var ceil: (date: Date) -> Date
    public var range: Range
    public var offset: (date: Date, step: Number) -> Date
    public var utc: Interval
}
native
public trait TimeFormat {
    public fun invoke(date: Date): String
    public var parse: (string: String) -> Date
}
}

object Layout {
    native
    public trait Layout {
        public fun stack(): StackLayout
        public fun pie(): PieLayout
        public fun force(): ForceLayout
        public fun tree(): TreeLayout
        public fun bundle(): BundleLayout
        public fun chord(): ChordLayout
        public fun cluster(): ClusterLayout
        public fun hierarchy(): HierarchyLayout
        public fun histogram(): HistogramLayout
        public fun pack(): PackLayout
        public fun partition(): PartitionLayout
        public fun treeMap(): TreeMapLayout
    }
    native
    public trait StackLayout {
        public fun invoke(layers: Array<Any>, index: Number? = null): Array<Any>
        public fun values(accessor: ((d: Any) -> Any)? = null): StackLayout
        public fun offset(offset: String): StackLayout
    }
    native
    public trait TreeLayout {
        public var sort: {
        /**
         * Gets the sort order function of sibling nodes for the layout
         */
        (): (d1: any, d2: any) => number;
        /**
         * Sets the sort order of sibling nodes for the layout using the specified comparator function
         */
        (comparator: (d1: any, d2: any) => number): TreeLayout;
    }
    public var children: {
    /**
     * Gets the children accessor function
     */
    (): (d: any) => any;
    /**
     * Sets the specified children accessor function
     */
    (children: (d: any) => any): TreeLayout;
}
public fun nodes(root: GraphNode): TreeLayout
public fun links(nodes: Array<GraphNode>): Array<GraphLink>
public var seperation: {
/**
 * Gets the current separation function
 */
(): (a: GraphNode, b: GraphNode) => number;
/**
 * Sets the specified function to compute separation between neighboring nodes
 */
(seperation: (a: GraphNode, b: GraphNode) => number): TreeLayout;
}
public var size: {
/**
 * Gets the available layout size
 */
(): number[];
/**
 * Sets the available layout size
 */
(size: number[]): TreeLayout;
}
}
native
public trait PieLayout {
    public fun invoke(values: Array<Any>, index: Number? = null): Array<ArcDescriptor>
    public var value: {
    (): (d: any, index: number) => number;
    (accessor: (d: any, index: number) => number): PieLayout;
}
public var sort: {
(): (d1: any, d2: any) => number;
(comparator: (d1: any, d2: any) => number): PieLayout;
}
public var startAngle: {
(): number;
(angle: number): D3.Svg.Arc;
(angle: () => number): D3.Svg.Arc;
(angle: (d : any) => number): D3.Svg.Arc;
(angle: (d : any, i: number) => number): D3.Svg.Arc;
}
public var endAngle: {
(): number;
(angle: number): D3.Svg.Arc;
(angle: () => number): D3.Svg.Arc;
(angle: (d : any) => number): D3.Svg.Arc;
(angle: (d : any, i: number) => number): D3.Svg.Arc;
}
}
native
public trait ArcDescriptor {
    public var value: Any
    public var data: Any
    public var startAngle: Number
    public var endAngle: Number
    public var index: Number
}
native
public trait GraphNode {
    public var id: Number
    public var index: Number
    public var name: String
    public var px: Number
    public var py: Number
    public var size: Number
    public var weight: Number
    public var x: Number
    public var y: Number
    public var subindex: Number
    public var startAngle: Number
    public var endAngle: Number
    public var value: Number
    public var fixed: Boolean
    public var children: Array<GraphNode>
    public var _children: Array<GraphNode>
    public var parent: GraphNode
    public var depth: Number
}
native
public trait GraphLink {
    public var source: GraphNode
    public var target: GraphNode
}
native
public trait ForceLayout {
    public fun invoke(): ForceLayout
    public var size: {
    (): number;
    (mysize: number[]): ForceLayout;
    (accessor: (d: any, index: number) => {
    }): ForceLayout;

}
public var linkDistance: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
public var linkStrength: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
public var friction: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
public var alpha: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
public var charge: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
public var theta: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
public var gravity: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
public var links: {
(): GraphLink[];
(arLinks: GraphLink[]): ForceLayout;

}
public var nodes: {
(): GraphNode[];
(arNodes: GraphNode[]): ForceLayout;

}
public fun start(): ForceLayout
public fun resume(): ForceLayout
public fun stop(): ForceLayout
public fun tick(): ForceLayout
public fun on(`type`: String, listener: () -> Unit): ForceLayout
public fun drag(): ForceLayout
}
native
public trait BundleLayout {
    public fun invoke(links: Array<GraphLink>): Array<GraphNode>
}
native
public trait ChordLayout {
    public var matrix: {
    (): Array<number[]>;
    (matrix: Array<number[]>): ChordLayout;
}

public var padding: {
(): number;
(padding: number): ChordLayout;
}

public var sortGroups: {
(): number[];
(comparator: (a: number, b: number) => number): ChordLayout;
}

public var sortSubgroups: {
(): number[];
(comparator: (a: number, b: number) => number): ChordLayout;
}

public var sortChords: {
(): GraphLink[];
(comparator: (a: number, b: number) => number): ChordLayout;
}

public fun chords(): Array<GraphLink>
public fun groups(): Array<ArcDescriptor>
}
native
public trait ClusterLayout {
    public var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): ClusterLayout;
}

public var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): ClusterLayout;
}

public fun nodes(root: GraphNode): Array<GraphNode>
public fun links(nodes: Array<GraphNode>): Array<GraphLink>
public var seperation: {
(): (a: GraphNode, b: GraphNode) => number;
(seperation: (a: GraphNode, b: GraphNode) => number): ClusterLayout;
}

public var size: {
(): number[];
(size: number[]): ClusterLayout;
}

public var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): ClusterLayout;
}

}
native
public trait HierarchyLayout {
    public var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): HierarchyLayout;
}

public var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): HierarchyLayout;
}

public fun nodes(root: GraphNode): Array<GraphNode>
public fun links(nodes: Array<GraphNode>): Array<GraphLink>
public var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): HierarchyLayout;
}

public fun reValue(root: GraphNode): HierarchyLayout
}
native
public trait Bin : any

[ ]  { x : number ; dx : number ; y : number ; } native
public trait HistogramLayout {
    public fun invoke(values: Array<Any>, index: Number? = null): Array<Bin>
    public var value: {
    (): (value: any) => any;
    (accessor: (value: any) => any): HistogramLayout
}

public var range: {
(): (value: any, index: number) => number[];
(range: (value: any, index: number) => number[]): HistogramLayout;
(range: number[]): HistogramLayout;
}

public var bins: {
(): (range: any[], index: number) => number[];
(bins: (range: any[], index: number) => number[]): HistogramLayout;
(bins: number): HistogramLayout;
(bins: number[]): HistogramLayout;
}

public var frequency: {
(): boolean;
(frequency: boolean): HistogramLayout;
}

}
native
public trait PackLayout {
    public var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): PackLayout;
}

public var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): PackLayout;
}

public fun nodes(root: GraphNode): Array<GraphNode>
public fun links(nodes: Array<GraphNode>): Array<GraphLink>
public var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): PackLayout;
}

public var size: {
(): number[];
(size: number[]): PackLayout;
}

public var padding: {
(): number;
(padding: number): PackLayout;
}

}
native
public trait PartitionLayout {
    public var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): PackLayout;
}

public var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): PackLayout;
}

public fun nodes(root: GraphNode): Array<GraphNode>
public fun links(nodes: Array<GraphNode>): Array<GraphLink>
public var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): PackLayout;
}

public var size: {
(): number[];
(size: number[]): PackLayout;
}

}
native
public trait TreeMapLayout {
    public var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): TreeMapLayout;
}

public var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): TreeMapLayout;
}

public fun nodes(root: GraphNode): Array<GraphNode>
public fun links(nodes: Array<GraphNode>): Array<GraphLink>
public var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): TreeMapLayout;
}

public var size: {
(): number[];
(size: number[]): TreeMapLayout;
}

public var padding: {
(): number;
(padding: number): TreeMapLayout;
}

public var round: {
(): boolean;
(round: boolean): TreeMapLayout;
}

public var sticky: {
(): boolean;
(sticky: boolean): TreeMapLayout;
}

public var mode: {
(): string;
(mode: string): TreeMapLayout;
}

}
}

object Color {

    native
    public trait Color {
        public fun brighter(k: Number): Color
        public fun darker(k: Number): Color
        public fun toString(): String
    }
    native
    public trait RGBColor : Color {
        public fun hsl(): HSLColor
    }
    native
    public trait HSLColor : Color {
        public fun rgb(): RGBColor
    }
    native
    public trait LABColor : Color {
        public fun rgb(): RGBColor
    }
    native
    public trait HCLColor : Color {
        public fun rgb(): RGBColor
    }
}

object Svg {

    native
    public trait Svg {
        public fun symbol(): Symbol
        public fun axis(): Axis
        public fun arc(): Arc
        public var line: {
        (): Line;
        radial(): LineRadial;
    }

    public var area: {
    (): Area;
    radial(): AreaRadial;
}

public fun brush(): Brush
public fun chord(): Chord
public var diagonal: {
(): Diagonal;
radial(): Diagonal;
}

public var symbolTypes: Array<String>
}
native
public trait Symbol {
    public var `type`: (string: String) -> Symbol
    public var size: (number: Number) -> Symbol
}
native
public trait Brush {
    public fun invoke(selection: Selection): Unit
    public var x: {
    /**
     * Gets  the x-scale associated with the brush
     */
    (): D3.Scale.Scale;
    /**
     * Sets the x-scale associated with the brush
     *
     * @param accessor The new Scale
     */
    (scale: D3.Scale.Scale): Brush;
}
public var y: {
/**
 * Gets  the x-scale associated with the brush
 */
(): D3.Scale.Scale;
/**
 * Sets the x-scale associated with the brush
 *
 * @param accessor The new Scale
 */
(scale: D3.Scale.Scale): Brush;
}
public var extent: {
/**
 * Gets the current brush extent
 */
(): any[];
/**
 * Sets the current brush extent
 */
(values: any[]): Brush;
}
public fun clear(): Brush
public fun empty(): Boolean
public var on: {
/**
 * Gets the listener for the specified event type
 */
(type: string): (data: any, index: number) => any;
/**
 * Sets the listener for the specified event type
 */
(type: string, listener: (data: any, index: number) => any, capture?: boolean): Brush;
}
}
native
public trait Axis {
    public fun invoke(selection: Selection): Unit
    public var scale: {
    (): any;
    (scale: any): Axis;
}
public var orient: {
(): string;
(orientation: string): Axis;
}
public var ticks: {
(): any[];
(...arguments: any[]): Axis;
}
public var tickPadding: {
(): number;
(padding: number): Axis;
}
public var tickValues: {
(): any[];
(values: any[]): Axis;
}
public fun tickSubdivide(count: Number): Axis
public fun tickSize(major: Number? = null, minor: Number? = null, end: Number? = null): Axis
public fun tickFormat(formatter: (value: Any) -> String): Axis
}
native
public trait Arc {
    public fun invoke(data: Any, index: Number? = null): String
    public var innerRadius: {
    (): (data: any, index?: number) => number;
    (radius: number): Arc;
    (radius: () => number): Arc;
    (radius: (data: any) => number): Arc;
    (radius: (data: any, index: number) => number): Arc;
}
public var outerRadius: {
(): (data: any, index?: number) => number;
(radius: number): Arc;
(radius: () => number): Arc;
(radius: (data: any) => number): Arc;
(radius: (data: any, index: number) => number): Arc;
}
public var startAngle: {
(): (data: any, index?: number) => number;
(angle: number): Arc;
(angle: () => number): Arc;
(angle: (data: any) => number): Arc;
(angle: (data: any, index: number) => number): Arc;
}
public var endAngle: {
(): (data: any, index?: number) => number;
(angle: number): Arc;
(angle: () => number): Arc;
(angle: (data: any) => number): Arc;
(angle: (data: any, index: number) => number): Arc;
}
public fun centroid(data: Any, index: Number? = null): Array<Number>
}
native
public trait Line {
    public fun invoke(data: Array<Any>, index: Number? = null): String
    public var x: {
    /**
     * Get the x-coordinate accessor.
     */
    (): (data: any, index ?: number) => number;
    /**
     * Set the x-coordinate accessor.
     *
     * @param accessor The new accessor function
     */
    (accessor: (data: any) => number): Line;
    (accessor: (data: any, index: number) => number): Line;
    /**
     * Set the  x-coordinate to a constant.
     *
     * @param cnst The new constant value.
     */
    (cnst: number): Line;
}
public var y: {
/**
 * Get the y-coordinate accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the y-coordinate accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): Line;
(accessor: (data: any, index: number) => number): Line;
/**
 * Set the  y-coordinate to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): Line;
}
public var interpolate: {
/**
 * Get the interpolation accessor.
 */
(): string;
/**
 * Set the interpolation accessor.
 *
 * @param interpolate The interpolation mode
 */
(interpolate: string): Line;
}
public var tension: {
/**
 * Get the cardinal spline accessor.
 */
(): number;
/**
 * Set the cardinal spline accessor.
 *
 * @param tension The Cardinal spline interpolation tension
 */
(tension: number): Line;
}
public var defined: {
/**
 * Get the accessor function that controls where the line is defined.
 */
(): (data: any, index ?: number) => boolean;
/**
 * Set the accessor function that controls where the area is defined.
 *
 * @param defined The new accessor function
 */
(defined: (data: any) => boolean): Line;
}
}
native
public trait LineRadial {
    public fun invoke(data: Array<Any>, index: Number? = null): String
    public var x: {
    /**
     * Get the x-coordinate accessor.
     */
    (): (data: any, index ?: number) => number;
    /**
     * Set the x-coordinate accessor.
     *
     * @param accessor The new accessor function
     */
    (accessor: (data: any) => number): LineRadial;
    (accessor: (data: any, index: number) => number): LineRadial;

    /**
     * Set the  x-coordinate to a constant.
     *
     * @param cnst The new constant value.
     */
    (cnst: number): LineRadial;
}
public var y: {
/**
 * Get the y-coordinate accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the y-coordinate accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): LineRadial;
(accessor: (data: any, index: number) => number): LineRadial;
/**
 * Set the  y-coordinate to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): LineRadial;
}
public var interpolate: {
/**
 * Get the interpolation accessor.
 */
(): string;
/**
 * Set the interpolation accessor.
 *
 * @param interpolate The interpolation mode
 */
(interpolate: string): LineRadial;
}
public var tension: {
/**
 * Get the cardinal spline accessor.
 */
(): number;
/**
 * Set the cardinal spline accessor.
 *
 * @param tension The Cardinal spline interpolation tension
 */
(tension: number): LineRadial;
}
public var defined: {
/**
 * Get the accessor function that controls where the line is defined.
 */
(): (data: any) => any;
/**
 * Set the accessor function that controls where the area is defined.
 *
 * @param defined The new accessor function
 */
(defined: (data: any) => any): LineRadial;
}
public var radius: {
(): (d: any, i?: number) => number;
(radius: number): LineRadial;
(radius: (d: any) => number): LineRadial;
(radius: (d: any, i: number) => number): LineRadial;
}

public var angle: {
(): (d: any, i?: any) => number;
(angle: number): LineRadial;
(angle: (d: any) => number): LineRadial;
(angle: (d: any, i: any) => number): LineRadial;
}

}
native
public trait Area {
    public fun invoke(data: Array<Any>, index: Number? = null): String
    public var x: {
    /**
     * Get the x-coordinate accessor.
     */
    (): (data: any, index ?: number) => number;
    /**
     * Set the x-coordinate accessor.
     *
     * @param accessor The new accessor function
     */
    (accessor: (data: any) => number): Area;
    (accessor: (data: any, index: number) => number): Area;
    /**
     * Set the  x-coordinate to a constant.
     *
     * @param cnst The new constant value.
     */
    (cnst: number): Area;
}
public var x0: {
/**
 * Get the  x0-coordinate (baseline) accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the  x0-coordinate (baseline) accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): Area;
(accessor: (data: any, index: number) => number): Area;
/**
 * Set the  x0-coordinate (baseline) to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): Area;
}
public var x1: {
/**
 * Get the  x1-coordinate (topline) accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the  x1-coordinate (topline) accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): Area;
(accessor: (data: any, index: number) => number): Area;
/**
 * Set the  x1-coordinate (topline) to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): Area;
}
public var y: {
/**
 * Get the y-coordinate accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the y-coordinate accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): Area;
(accessor: (data: any, index: number) => number): Area;
/**
 * Set the y-coordinate to a constant.
 *
 * @param cnst The constant value
 */
(cnst: number): Area;
}
public var y0: {
/**
 * Get the y0-coordinate (baseline) accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the y0-coordinate (baseline) accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): Area;
(accessor: (data: any, index: number) => number): Area;
/**
 * Set the y0-coordinate (baseline) to a constant.
 *
 * @param cnst The constant value
 */
(cnst: number): Area;
}
public var y1: {
/**
 * Get the y1-coordinate (topline) accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the y1-coordinate (topline) accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): Area;
(accessor: (data: any, index: number) => number): Area;
/**
 * Set the y1-coordinate (baseline) to a constant.
 *
 * @param cnst The constant value
 */
(cnst: number): Area;
}
public var interpolate: {
/**
 * Get the interpolation accessor.
 */
(): string;
/**
 * Set the interpolation accessor.
 *
 * @param interpolate The interpolation mode
 */
(interpolate: string): Area;
}
public var tension: {
/**
 * Get the cardinal spline accessor.
 */
(): number;
/**
 * Set the cardinal spline accessor.
 *
 * @param tension The Cardinal spline interpolation tension
 */
(tension: number): Area;
}
public var defined: {
/**
 * Get the accessor function that controls where the area is defined.
 */
(): (data: any) => any;
/**
 * Set the accessor function that controls where the area is defined.
 *
 * @param defined The new accessor function
 */
(defined: (data: any) => any): Area;
}
}
native
public trait AreaRadial {
    public fun invoke(data: Array<Any>, index: Number? = null): String
    public var x: {
    /**
     * Get the x-coordinate accessor.
     */
    (): (data: any, index ?: number) => number;
    /**
     * Set the x-coordinate accessor.
     *
     * @param accessor The new accessor function
     */
    (accessor: (data: any) => number): AreaRadial;
    (accessor: (data: any, index: number) => number): AreaRadial;
    /**
     * Set the  x-coordinate to a constant.
     *
     * @param cnst The new constant value.
     */
    (cnst: number): AreaRadial;
}
public var x0: {
/**
 * Get the  x0-coordinate (baseline) accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the  x0-coordinate (baseline) accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): AreaRadial;
(accessor: (data: any, index: number) => number): AreaRadial;
/**
 * Set the  x0-coordinate to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): AreaRadial;
}
public var x1: {
/**
 * Get the  x1-coordinate (topline) accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the  x1-coordinate (topline) accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): AreaRadial;
(accessor: (data: any, index: number) => number): AreaRadial;
/**
 * Set the  x1-coordinate to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): AreaRadial;
}
public var y: {
/**
 * Get the y-coordinate accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the y-coordinate accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): AreaRadial;
(accessor: (data: any, index: number) => number): AreaRadial;
/**
 * Set the y-coordinate to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): AreaRadial;
}
public var y0: {
/**
 * Get the y0-coordinate (baseline) accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the y0-coordinate (baseline) accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): AreaRadial;
(accessor: (data: any, index: number) => number): AreaRadial;
/**
 * Set the  y0-coordinate to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): AreaRadial;
}
public var y1: {
/**
 * Get the y1-coordinate (topline) accessor.
 */
(): (data: any, index ?: number) => number;
/**
 * Set the y1-coordinate (topline) accessor.
 *
 * @param accessor The new accessor function
 */
(accessor: (data: any) => number): AreaRadial;
(accessor: (data: any, index: number) => number): AreaRadial;
/**
 * Set the  y1-coordinate to a constant.
 *
 * @param cnst The new constant value.
 */
(cnst: number): AreaRadial;
}
public var interpolate: {
/**
 * Get the interpolation accessor.
 */
(): string;
/**
 * Set the interpolation accessor.
 *
 * @param interpolate The interpolation mode
 */
(interpolate: string): AreaRadial;
}
public var tension: {
/**
 * Get the cardinal spline accessor.
 */
(): number;
/**
 * Set the cardinal spline accessor.
 *
 * @param tension The Cardinal spline interpolation tension
 */
(tension: number): AreaRadial;
}
public var defined: {
/**
 * Get the accessor function that controls where the area is defined.
 */
(): (data: any) => any;
/**
 * Set the accessor function that controls where the area is defined.
 *
 * @param defined The new accessor function
 */
(defined: (data: any) => any): AreaRadial;
}
public var radius: {
(): number;
(radius: number): AreaRadial;
(radius: () => number): AreaRadial;
(radius: (data: any) => number): AreaRadial;
(radius: (data: any, index: number) => number): AreaRadial;
}
public var innerRadius: {
(): number;
(radius: number): AreaRadial;
(radius: () => number): AreaRadial;
(radius: (data: any) => number): AreaRadial;
(radius: (data: any, index: number) => number): AreaRadial;
}
public var outerRadius: {
(): number;
(radius: number): AreaRadial;
(radius: () => number): AreaRadial;
(radius: (data: any) => number): AreaRadial;
(radius: (data: any, index: number) => number): AreaRadial;
}
public var angle: {
(): number;
(angle: number): AreaRadial;
(angle: () => number): AreaRadial;
(angle: (data: any) => number): AreaRadial;
(angle: (data: any, index: number) => number): AreaRadial;
}
public var startAngle: {
(): number;
(angle: number): AreaRadial;
(angle: () => number): AreaRadial;
(angle: (data: any) => number): AreaRadial;
(angle: (data: any, index: number) => number): AreaRadial;
}
public var endAngle: {
(): number;
(angle: number): AreaRadial;
(angle: () => number): AreaRadial;
(angle: (data: any) => number): AreaRadial;
(angle: (data: any, index: number) => number): AreaRadial;
}
}
native
public trait Chord {
    public fun invoke(datum: Any, index: Number? = null): String
    public var radius: {
    (): number;
    (radius: number): Chord;
    (radius: () => number): Chord;
}
public var startAngle: {
(): number;
(angle: number): Chord;
(angle: () => number): Chord;
}
public var endAngle: {
(): number;
(angle: number): Chord;
(angle: () => number): Chord;
}
public var source: {
(): any;
(angle: any): Chord;
(angle: (d: any, i?: number) => any): Chord;
}
public var target: {
(): any;
(angle: any): Chord;
(angle: (d: any, i?: number) => any): Chord;
}
}
native
public trait Diagonal {
    public fun invoke(datum: Any, index: Number? = null): String
    public var projection: {
    (): (datum: any, index?: number) => number[];
    (proj: (datum: any) => number[]): Diagonal;
    (proj: (datum: any, index: number) => number[]): Diagonal;
}
public var source: {
(): (datum: any, index?: number) => any;
(src: (datum: any) => any): Diagonal;
(src: (datum: any, index: number) => any): Diagonal;
(src: any): Diagonal;
}
public var target: {
(): (datum: any, index?: number) => any;
(target: (d: any) => any): Diagonal;
(target: (d: any, i: number) => any): Diagonal;
(target: any): Diagonal;
}
}
}

object Scale {

    native
    public trait ScaleBase {
        public fun linear(): LinearScale
        public fun ordinal(): OrdinalScale
        public fun quantize(): QuantizeScale
        public fun category10(): OrdinalScale
        public fun category20(): OrdinalScale
        public fun category20b(): OrdinalScale
        public fun category20c(): OrdinalScale
        public fun identity(): IdentityScale
        public fun log(): LogScale
        public fun pow(): PowScale
        public fun quantile(): QuantileScale
        public fun sqrt(): SqrtScale
        public fun theshold(): ThresholdScale
    }
    native
    public trait Scale {
        public fun invoke(value: Any): Any
        public var domain: {
        (values: any[]): Scale;
        (): any[];
    }
    public var range: {
    (values: any[]): Scale;
    (): any[];
}
public fun copy(): Scale
}
native
public trait QuantitiveScale : Scale {
    public fun invoke(value: Number): Number
    public fun invert(value: Number): Number
    public var domain: {
    /**
     * Set the scale's input domain.
     *
     * @param value The input domain
     */
    (values: any[]): QuantitiveScale;
    /**
     * Get the scale's input domain.
     */
    (): any[];
}
public var range: {
/**
 * Set the scale's output range.
 *
 * @param value The output range.
 */
(values: any[]): QuantitiveScale;
/**
 * Get the scale's output range.
 */
(): any[];
}
public var rangeRound: (values: Array<Any>) -> QuantitiveScale
public var interpolate: {
(): D3.Transition.Interpolate;
(factory: D3.Transition.Interpolate): QuantitiveScale;
}
public fun clamp(clamp: Boolean): QuantitiveScale
public fun nice(): QuantitiveScale
public fun ticks(count: Number): Array<Any>
public fun tickFormat(count: Number): (n: Number) -> String
public fun copy(): QuantitiveScale
}
native
public trait LinearScale : QuantitiveScale {
    public fun invoke(value: Number): Number
}
native
public trait IdentityScale : QuantitiveScale {
    public fun invoke(value: Number): Number
}
native
public trait SqrtScale : QuantitiveScale {
    public fun invoke(value: Number): Number
}
native
public trait PowScale : QuantitiveScale {
    public fun invoke(value: Number): Number
}
native
public trait LogScale : QuantitiveScale {
    public fun invoke(value: Number): Number
}
native
public trait OrdinalScale : Scale {
    public fun invoke(value: Any): Any
    public var domain: {
    /**
     * Set the scale's input domain.
     *
     * @param value The input domain
     */
    (values: any[]): OrdinalScale;
    /**
     * Get the scale's input domain.
     */
    (): any[];
}
public var range: {
/**
 * Set the scale's output range.
 *
 * @param value The output range.
 */
(values: any[]): OrdinalScale;
/**
 * Get the scale's output range.
 */
(): any[];
}
public fun rangePoints(interval: Array<Any>, padding: Number? = null): OrdinalScale
public fun rangeBands(interval: Array<Any>, padding: Number? = null, outerPadding: Number? = null): OrdinalScale
public fun rangeRoundBands(interval: Array<Any>, padding: Number? = null, outerPadding: Number? = null): OrdinalScale
public fun rangeBand(): Number
public fun rangeExtent(): Array<Any>
public fun copy(): OrdinalScale
}
native
public trait QuantizeScale : Scale {
    public fun invoke(value: Any): Any
    public var domain: {
    (values: number[]): QuantizeScale;
    (): any[];
}
public var range: {
(values: any[]): QuantizeScale;
(): any[];
}
public fun copy(): QuantizeScale
}
native
public trait ThresholdScale : Scale {
    public fun invoke(value: Any): Any
    public var domain: {
    (values: number[]): ThresholdScale;
    (): any[];
}
public var range: {
(values: any[]): ThresholdScale;
(): any[];
}
public fun copy(): ThresholdScale
}
native
public trait QuantileScale : Scale {
    public fun invoke(value: Any): Any
    public var domain: {
    (values: number[]): QuantileScale;
    (): any[];
}
public var range: {
(values: any[]): QuantileScale;
(): any[];
}
public fun quantiles(): Array<Any>
public fun copy(): QuantileScale
}
native
public trait TimeScale : Scale {
    public fun invoke(value: Date): Number
    public fun invert(value: Number): Date
    public var domain: {
    (values: any[]): TimeScale;
    (): any[];
}
public var range: {
(values: any[]): TimeScale;
(): any[];
}
public var rangeRound: (values: Array<Any>) -> TimeScale
public var interpolate: {
(): D3.Transition.Interpolate;
(factory: D3.Transition.InterpolateFactory): TimeScale;
}
public fun clamp(clamp: Boolean): TimeScale
public var ticks: {
(count: number): any[];
(range: Range, count: number): any[];
}
public fun tickFormat(count: Number): (n: Number) -> String
public fun copy(): TimeScale
}
}

object Behavior {
    native
    public trait Behavior {
        public fun drag(): Drag
        public fun zoom(): Zoom
    }

    native
    public trait Zoom {
        public fun invoke(): Any
        public var on: (`type`: String, listener: (data: Any, index: Number? = null) -> Any) -> Zoom
        public var scale: {
        /**
         * Get the current current zoom scale
         */
        (): number;
        /**
         * Set the current current zoom scale
         *
         * @param origin Zoom scale
         */
        (scale: number): Zoom;
    }
    public var translate: {
    /**
     * Get the current zoom translation vector
     */
    (): number[];
    /**
     * Set the current zoom translation vector
     *
     * @param translate Tranlation vector
     */
    (translate: number[]): Zoom;
}
public var scaleExtent: {
/**
 * Get the current allowed zoom range
 */
(): number[];
/**
 * Set the allowable zoom range
 *
 * @param extent Allowed zoom range
 */
(extent: number[]): Zoom;
}
public var x: {
/**
 * Get the X-Scale
 */
(): D3.Scale.Scale;
/**
 * Set the X-Scale to be adjusted
 *
 * @param x The X Scale
 */
(x: D3.Scale.Scale): Zoom;

}
public var y: {
/**
 * Get the Y-Scale
 */
(): D3.Scale.Scale;
/**
 * Set the Y-Scale to be adjusted
 *
 * @param y The Y Scale
 */
(y: D3.Scale.Scale): Zoom;
}
}
native
public trait Drag {
    public fun invoke(): Any
    public var on: (`type`: String, listener: (data: Any, index: Number? = null) -> Any) -> Drag
    public var origin: {
    /**
     * Get the current origin accessor function
     */
    (): any;
    /**
     * Set the origin accessor function
     *
     * @param origin Accessor function
     */
    (origin?: any): Drag;
}
}
}

object Geo {

    native
    public trait Geo {
        public fun path(): Path
        public fun circle(): Circle
        public fun area(feature: Any): Number
        public fun bounds(feature: Any): Array<number[]>
        public fun centroid(feature: Any): Array<Number>
        public fun distance(a: Array<Number>, b: Array<Number>): Number
        public fun interpolate(a: Array<Number>, b: Array<Number>): (t: Number) -> Array<Number>
        public fun length(feature: Any): Number
        public fun projection(raw: (lambda: Any, phi: Any) -> Any): Projection
        public fun projectionMutator(rawFactory: (lambda: Number, phi: Number) -> Array<Number>): Projection
        public fun albers(): Projection
        public fun albersUsa(): Projection
        public var azimuthalEqualArea: {
        (): Projection;
        raw(): Projection;
    }

    public var azimuthalEquidistant: {
    (): Projection;
    raw(): Projection;
}

public var conicConformal: {
(): Projection;
raw(): Projection;
}

public var conicEquidistant: {
(): Projection;
raw(): Projection;
}

public var conicEqualArea: {
(): Projection;
raw(): Projection;
}

public var equirectangular: {
(): Projection;
raw(): Projection;
}

public var gnomonic: {
(): Projection;
raw(): Projection;
}

public var mercator: {
(): Projection;
raw(): Projection;
}

public var othographic: {
(): Projection;
raw(): Projection;
}

public var stereographic: {
(): Projection;
raw(): Projection;
}

public var transverseMercator: {
(): Projection;
raw(): Projection;
}

public fun stream(`object`: GeoJSON, listener: Any): Stream
public fun graticule(): Graticule
public var greatArc: GreatArc
public fun rotation(rotation: Array<Number>): Rotation
}
native
public trait Path {
    public fun invoke(feature: Any, index: Any? = null): String
    public var projection: {
    /**
     * get the geographic projection.
     */
    (): Projection;
    /**
     * set the geographic projection.
     */
    (projection: Projection): Path;
}

public var context: {
/**
 * return an SVG path string invoked on the given feature.
 */
(): string;
/**
 * sets the render context and returns the path generator
 */
(context: Context): Path;
}

public fun area(feature: Any): Any
public fun centroid(feature: Any): Any
public fun bounds(feature: Any): Any
public var pointRadius: {
/**
 * returns the current radius
 */
(): number;
/**
 * sets the radius used to display Point and MultiPoint features to the specified number
 */
(radius: number): Path;
/**
 * sets the radius used to display Point and MultiPoint features to the specified number
 */
(radius: (feature: any, index: number) => number): Path;
}

}
native
public trait Context {
    public fun beginPath(): Any
    public fun moveTo(x: Number, y: Number): Any
    public fun lineTo(x: Number, y: Number): Any
    public fun arc(x: Number, y: Number, radius: Number, startAngle: Number, endAngle: Number): Any
    public fun closePath(): Any
}
native
public trait Circle {
    public fun invoke(vararg args: Any): GeoJSON
    public var origin: {
    (): number[];
    (origin: number[]): Circle;
    (origin: (...args: any[]) => number[]): Circle;
}

public var angle: {
(): number;
(angle: number): Circle;
}

public var precision: {
(): number;
(precision: number): Circle;
}

}
native
public trait Graticule {
    public fun invoke(): GeoJSON
    public fun lines(): GeoJSON
    public fun outline(): GeoJSON
    public var extent: {
    (): Array<number[]>;
    (extent: Array<number[]>): Graticule;
}

public var minorExtent: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

public var majorExtent: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

public var step: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

public var minorStep: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

public var majorStep: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

public var precision: {
(): number;
(precision: number): Graticule;
}

}
native
public trait GreatArc {
    public fun invoke(): GeoJSON
    public fun distance(): Number
    public var source: {
    (): any;
    (source: any): GreatArc;
}

public var target: {
(): any;
(target: any): GreatArc;
}

public var precision: {
(): number;
(precision: number): GreatArc;
}

}
native
public trait GeoJSON {
    public var coordinates: Array<number[]>
    public var `type`: String
}
native
public trait Projection {
    public fun invoke(coordinates: Array<Number>): Array<Number>
    public fun invert(point: Array<Number>): Array<Number>
    public var rotate: {
    (): number[];
    (rotation: number[]): Projection;
}
public var center: {
(): number[];
(location: number[]): Projection;
}
public var translate: {
(): number[];
(point: number[]): Projection;
}
public var scale: {
(): number;
(scale: number): Projection;
}
public var clipAngle: {
(): number;
(angle: number): Projection;
}
public var clipExtent: {
(): Array<number[]>;
(extent: Array<number[]>): Projection;
}
public var precision: {
(): number;
(precision: number): Projection;
}
public fun stream(listener: Any? = null): Stream
}
native
public trait Stream {
    public fun point(x: Number, y: Number, z: Number? = null): Unit
    public fun lineStart(): Unit
    public fun lineEnd(): Unit
    public fun polygonStart(): Unit
    public fun polygonEnd(): Unit
    public fun sphere(): Unit
}
native
public trait Rotation : any

[ ]  {
public fun invoke(location: Array<Number>): Rotation   ; invert (location number [  ])  Rotation ; } }

object Geom {

    native
    public trait Geom {
        public var voronoi: Voronoi
        public fun delaunay(vertices: Array<Vertice>? = null): Array<Polygon>
        public var quadtree: Quadtree
        public var polygon: Polygon
        public var hull: Hull
    }
    native
    public trait Vertice : number

    [ ]  {
        angle ?  : number ;
    } native
    public trait Polygon : Vertice

    [ ]  {
        public fun invoke(vertices: Array<Vertice>): Polygon   ; area ( )  number ; centroid ()  number [  ] ; clip (subject Polygon)  Polygon ;
    } native
    public trait Quadtree {
        public fun invoke(): Quadtree
        public fun invoke(points: Array<Point>, x1: Number, y1: Number, x2: Number, y2: Number): Quadtree
        public fun invoke(points: Array<Point>, width: Number, height: Number): Quadtree
        public fun add(point: Point): Quadtree
        public fun visit(callback: Any): Quadtree
        public var x: {
        (): (d: any) => any;
        (accesor: (d: any) => any): Quadtree;

    }

    public var y: {
    (): (d: any) => any;
    (accesor: (d: any) => any): Quadtree;

}

public fun size(size: Array<Number>): Quadtree
}
native
public trait Point {
    public var x: Number
    public var y: Number
}
native
public trait Voronoi {
    public fun invoke(vertices: Array<Vertice>? = null): Array<Polygon>
    public var x: {
    (): (d: any) => any;
    (accesor: (d: any) => any): any;
}

public var y: {
(): (d: any) => any;
(accesor: (d: any) => any): any;
}

}
native
public trait Hull {
    public fun invoke(vertices: Array<Vertice>): Hull
    public var x: {
    (): (d: any) => any;
    (accesor: (d: any) => any): any;
}

public var y: {
(): (d: any) => any;
(accesor: (d: any) => any): any;
}

}
} }
native
public var d3: D3.Base = noImpl
*/
