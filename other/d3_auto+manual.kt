package d3
/*
object D3 {

    @native
    trait Selectors {
        //    var select: {
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
        //    var selectAll: {
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
    @native
    trait Event {
        var dx: Number
        var dy: Number
        var clientX: Number
        var clientY: Number
        var translate: Array<Number>
        var scale: Number
        var sourceEvent: Event
        var x: Number
        var y: Number
        var keyCode: Number
        var altKey: Any
    }
    @native
    trait Base : Selectors {
        var behavior: Behavior.Behavior
        var event: Event
        fun ascending<T>(a: T, b: T): Number
        fun descending<T>(a: T, b: T): Number
        fun min<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        fun max<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        fun extent<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Array<Number>
        fun sum<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        fun mean<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        fun median<T>(arr: Array<T>, map: ((v: T) -> Number)? = null): Number
        var quantile: (arr: Array<Number>, p: Number) -> Number
        fun bisect<T>(arr: Array<T>, x: T, low: Number? = null, high: Number? = null): Number
        fun bisectLeft<T>(arr: Array<T>, x: T, low: Number? = null, high: Number? = null): Number
        fun bisectRight<T>(arr: Array<T>, x: T, low: Number? = null, high: Number? = null): Number
        fun bisector(accessor: (data: Any, index: Number) -> Any): Any
        fun shuffle<T>(arr: Array<T>): Array<T>
        fun permute(arr: Array<Any>, indexes: Array<Any>): Array<Any>
        fun zip(vararg arrs: Any): Array<Any>
        fun transform(definition: String): Any
        fun transpose(matrix: Array<Any>): Array<Any>
        fun keys(map: Array<Any>): Array<Any>
        fun values(map: Array<Any>): Array<Any>
        fun entries(map: Array<Any>): Array<Any>
        fun merge(vararg map: Any): Array<Any>
//        var range: {
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
        fun nest(): Nest
//    var xhr: {
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
//var text: {
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
var json: (url: String, callback: ((error: Any, data: Any) -> Unit)? = null) -> Xhr
//var xml: {
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
var html: (url: String, callback: ((response: DocumentFragment) -> Unit)? = null) -> Xhr
var csv: Dsv
var tsv: Dsv
var time: Time.Time
var scale: Scale.ScaleBase
var interpolate: Transition.BaseInterpolate
var interpolateNumber: Transition.BaseInterpolate
var interpolateRound: Transition.BaseInterpolate
var interpolateString: Transition.BaseInterpolate
var interpolateRgb: Transition.BaseInterpolate
var interpolateHsl: Transition.BaseInterpolate
var interpolateHcl: Transition.BaseInterpolate
var interpolateLab: Transition.BaseInterpolate
var interpolateArray: Transition.BaseInterpolate
var interpolateObject: Transition.BaseInterpolate
var interpolateTransform: Transition.BaseInterpolate
var interpolators: Array<Transition.InterpolateFactory>
var layout: Layout.Layout
var svg: Svg.Svg
var random: Random
fun format(specifier: String): (value: Number) -> String
fun formatPrefix(value: Number, precision: Number? = null): MetricPrefix
var version: String
fun selection(): Selection
//var ns: {
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
var ease: (`type`: String, vararg arrs: Any) -> D3.Transition.Transition
//var rgb: {
///**
// * Constructs a new RGB color with the specified r, g and b channel values
// */
//(r: number, g: number, b: number): D3.Color.RGBColor;
///**
// * Constructs a new RGB color by parsing the specified color string
// */
//(color: string): D3.Color.RGBColor;
//}
//var hcl: {
///**
// * Constructs a new HCL color.
// */
//(h: number, c: number, l: number): Color.HCLColor;
///**
// * Constructs a new HCL color by parsing the specified color string
// */
//(color: string): Color.HCLColor;
//}
//var hsl: {
///**
// * Constructs a new HSL color with the specified hue h, saturation s and lightness l
// */
//(h: number, s: number, l: number): Color.HSLColor;
///**
// * Constructs a new HSL color by parsing the specified color string
// */
//(color: string): Color.HSLColor;
//}
//var lab: {
///**
// * Constructs a new LAB color.
// */
//(l: number, a: number, b: number): Color.LABColor;
///**
// * Constructs a new LAB color by parsing the specified color string
// */
//(color: string): Color.LABColor;
//}
var geo: Geo.Geo
var geom: Geom.Geom
fun mouse(container: Any): Array<Number>
fun touches(container: Any): Array<Number>
fun functor<R, T>(value: (p: R) -> T): (p: R) -> T
fun functor<T>(value: T): (p: Any) -> T
fun map(`object`: Any? = null): Map
fun set(array: Array<Any>? = null): Set
fun dispatch(vararg types: String): Dispatch
fun rebind(target: Any, source: Any, vararg names: Any): Any
fun requote(str: String): String
//var timer: {
//(funct: () => boolean, delay?: number, mark?: number): void;
//flush(): void;
//}

fun transition(): Transition.Transition
fun round(x: Number, n: Number): Number
}
@native
trait Dispatch {
    fun get(event: String): Any
    fun set(event: String, value: Any)
//    var on: {
//    (type: string): any;
//    (type: string, listener: any): any;
//}

}
@native
trait MetricPrefix {
    var scale: (d: Number) -> Number
    var symbol: String
}
@native
trait Xhr {
//    var header: {
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
//var mimeType: {
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
//var response: {
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
fun get(callback: ((xhr: XMLHttpRequest) -> Unit)? = null): Xhr
//var post: {
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
//var send: {
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
fun abort(): Xhr
var on: (`type`: String, listener: (data: Any, index: Number? = null) -> Any) -> Xhr
}
@native
trait Dsv {
    fun invoke(url: String, callback: ((error: Any, response: Array<Any>) -> Unit)? = null): Xhr
    fun parse(string: String): Array<Any>
    fun parseRows(string: String, accessor: (row: Array<Any>, index: Number) -> Any): Any
    fun format(rows: Array<Any>): String
}
@native
trait Selection : Selectors, Array<Any>  {
    attr : {
fun invoke(name: String): String   ;
fun invoke(name: String, value: Any): Selection   ;
fun invoke(name: String, valueFunction: (data: Any, index: Number) -> Any): Selection   ;
fun invoke(attrValueMap: Any): Selection   ; } ; classed : {
fun invoke(name: String): String   ;
fun invoke(name: String, value: Any): Selection   ;
fun invoke(name: String, valueFunction: (data: Any, index: Number) -> Any): Selection   ; } ; style : {
fun invoke(name: String): String   ;
fun invoke(name: String, value: Any, priority: String? = null): Selection   ;
fun invoke(name: String, valueFunction: (data: Any, index: Number) -> Any, priority: String? = null): Selection   ; } ; property : {
fun invoke(name: String): Unit   ;
fun invoke(name: String, value: Any): Selection   ;
fun invoke(name: String, valueFunction: (data: Any, index: Number) -> Any): Selection   ; } ; text : {
fun invoke(): String   ;
fun invoke(value: Any): Selection   ;
fun invoke(valueFunction: (data: Any, index: Number) -> Any): Selection   ; } ; html : {
fun invoke(): String   ;
fun invoke(value: Any): Selection   ;
fun invoke(valueFunction: (data: Any, index: Number) -> Any): Selection   ; } ; append :
fun invoke(name: String) => Selection ; insert :
fun invoke(name: String, before: String) => Selection ; remove :
fun invoke() => Selection ; data : {
fun invoke(values: (data: Any, index: Number? = null) -> Array<Any>, key: ((data: Any, index: Number? = null) -> String)? = null): UpdateSelection   ;
fun invoke(values: Array<Any>, key: ((data: Any, index: Number? = null) -> String)? = null): UpdateSelection   ; } ; datum : {
fun invoke(values: (data: Any, index: Number) -> Any): UpdateSelection   ;
fun invoke(values: Any): UpdateSelection   ; } ; filter : {
fun invoke(filter: (data: Any, index: Number) -> Boolean, thisArg: Any? = null): UpdateSelection   ; } ; call (callback public
fun invoke(selection: Selection) => Unit  )  Selection ; each (eachFunction public
fun invoke(data: Any, index: Number) => any )  Selection ; on : {
fun invoke(`type`: String): (data: Any, index: Number) -> Any   ;
fun invoke(`type`: String, listener: (data: Any, index: Number) -> Any, capture: Boolean? = null): Selection   ; } ; transition ()  Transition . Transition ; sort<T> (comparator ?  :
fun invoke(a: T, b: T) => number )  Selection ; order :
fun invoke() => Selection ; node :
fun invoke() => Element ; } @native
trait EnterSelection {
    var append: (name: String) -> Selection
    var insert: (name: String, before: String) -> Selection
    var select: (selector: String) -> Selection
    var empty: () -> Boolean
    var node: () -> Element
}
@native
trait UpdateSelection : Selection {
    var enter: () -> EnterSelection
    var update: () -> Selection
    var exit: () -> Selection
}
@native
trait NestKeyValue {
    var key: String
    var values: Any
}
@native
trait Nest {
    fun key(keyFunction: (data: Any, index: Number) -> String): Nest
    fun sortKeys(comparator: (d1: Any, d2: Any) -> Number): Nest
    fun sortValues(comparator: (d1: Any, d2: Any) -> Number): Nest
    fun rollup(rollupFunction: (data: Any, index: Number) -> Any): Nest
    fun map(values: Array<Any>): Any
    fun entries(values: Array<Any>): Array<NestKeyValue>
}
@native
trait Map {
    fun has(key: String): Boolean
    fun get(key: String): Any
    fun set<T>(key: String, value: T): T
    fun remove(key: String): Boolean
    fun keys(): Array<String>
    fun values(): Array<Any>
    fun entries(): Array<Any>
    fun forEach(func: (key: String, value: Any) -> Unit): Unit
}
@native
trait Set {
    fun has(value: Any): Boolean
    fun Add(value: Any): Any
    fun remove(value: Any): Boolean
    fun values(): Array<Any>
    fun forEach(func: (value: Any) -> Unit): Unit
}
@native
trait Random {
    fun normal(mean: Number? = null, deviation: Number? = null): () -> Number
    fun logNormal(mean: Number? = null, deviation: Number? = null): () -> Number
    fun irwinHall(count: Number): () -> Number
}

object Transition {

    @native
    trait Transition {
        var duration: {
        (duration: number): Transition;
        (duration: (data: any, index: number) => any): Transition;
    }
    var delay: {
    (delay: number): Transition;
    (delay: (data: any, index: number) => any): Transition;
}
var attr: {
(name: string): string;
(name: string, value: any): Transition;
(name: string, valueFunction: (data: any, index: number) => any): Transition;
(attrValueMap : any): Transition;
}
var style: {
(name: string): string;
(name: string, value: any, priority?: string): Transition;
(name: string, valueFunction: (data: any, index: number) => any, priority?: string): Transition;
}
fun call(callback: (selection: Selection) -> Unit): Transition
var select: {
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
var selectAll: {
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

var each: (`type`: String? = null, eachFunction: ((data: Any, index: Number) -> Any)? = null) -> Transition
var transition: () -> Transition
var ease: (value: String, vararg arrs: Any) -> Transition
fun attrTween(name: String, tween: (d: Any, i: Number, a: Any) -> BaseInterpolate): Transition
fun styleTween(name: String, tween: (d: Any, i: Number, a: Any) -> BaseInterpolate, priority: String? = null): Transition
var text: {
(text: string): Transition;
(text: (d: any, i: number) => string): Transition;
}

fun tween(name: String, factory: InterpolateFactory): Transition
var filter: {
(selector: string): Transition;
(selector: (data: any, index: number) => boolean): Transition;
}
fun remove(): Transition
}
@native
trait InterpolateFactory {
    fun invoke(a: Any? = null, b: Any? = null): BaseInterpolate
}
@native
trait BaseInterpolate {
    fun invoke(a: Any, b: Any? = null): Any
}
@native
trait Interpolate {
    fun invoke(t: Any): Any
}
}

object Time {

    @native
    trait Time {
        var second: Interval
        var minute: Interval
        var hour: Interval
        var day: Interval
        var week: Interval
        var sunday: Interval
        var monday: Interval
        var tuesday: Interval
        var wednesday: Interval
        var thursday: Interval
        var friday: Interval
        var saturday: Interval
        var month: Interval
        var year: Interval
        var seconds: Range
        var minutes: Range
        var hours: Range
        var days: Range
        var weeks: Range
        var months: Range
        var years: Range
        var sundays: Range
        var mondays: Range
        var tuesdays: Range
        var wednesdays: Range
        var thursdays: Range
        var fridays: Range
        var saturdays: Range
        var format: {

        (specifier: string): TimeFormat;
        utc: (specifier: string) => TimeFormat;
        iso: TimeFormat;
    }
    fun scale(): Scale.TimeScale
}
@native
trait Range {
    fun invoke(start: Date, end: Date, step: Number? = null): Array<Date>
}
@native
trait Interval {
    fun invoke(date: Date): Date
    var floor: (date: Date) -> Date
    var round: (date: Date) -> Date
    var ceil: (date: Date) -> Date
    var range: Range
    var offset: (date: Date, step: Number) -> Date
    var utc: Interval
}
@native
trait TimeFormat {
    fun invoke(date: Date): String
    var parse: (string: String) -> Date
}
}

object Layout {
    @native
    trait Layout {
        fun stack(): StackLayout
        fun pie(): PieLayout
        fun force(): ForceLayout
        fun tree(): TreeLayout
        fun bundle(): BundleLayout
        fun chord(): ChordLayout
        fun cluster(): ClusterLayout
        fun hierarchy(): HierarchyLayout
        fun histogram(): HistogramLayout
        fun pack(): PackLayout
        fun partition(): PartitionLayout
        fun treeMap(): TreeMapLayout
    }
    @native
    trait StackLayout {
        fun invoke(layers: Array<Any>, index: Number? = null): Array<Any>
        fun values(accessor: ((d: Any) -> Any)? = null): StackLayout
        fun offset(offset: String): StackLayout
    }
    @native
    trait TreeLayout {
        var sort: {
        /**
         * Gets the sort order function of sibling nodes for the layout
         */
        (): (d1: any, d2: any) => number;
        /**
         * Sets the sort order of sibling nodes for the layout using the specified comparator function
         */
        (comparator: (d1: any, d2: any) => number): TreeLayout;
    }
    var children: {
    /**
     * Gets the children accessor function
     */
    (): (d: any) => any;
    /**
     * Sets the specified children accessor function
     */
    (children: (d: any) => any): TreeLayout;
}
fun nodes(root: GraphNode): TreeLayout
fun links(nodes: Array<GraphNode>): Array<GraphLink>
var seperation: {
/**
 * Gets the current separation function
 */
(): (a: GraphNode, b: GraphNode) => number;
/**
 * Sets the specified function to compute separation between neighboring nodes
 */
(seperation: (a: GraphNode, b: GraphNode) => number): TreeLayout;
}
var size: {
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
@native
trait PieLayout {
    fun invoke(values: Array<Any>, index: Number? = null): Array<ArcDescriptor>
    var value: {
    (): (d: any, index: number) => number;
    (accessor: (d: any, index: number) => number): PieLayout;
}
var sort: {
(): (d1: any, d2: any) => number;
(comparator: (d1: any, d2: any) => number): PieLayout;
}
var startAngle: {
(): number;
(angle: number): D3.Svg.Arc;
(angle: () => number): D3.Svg.Arc;
(angle: (d : any) => number): D3.Svg.Arc;
(angle: (d : any, i: number) => number): D3.Svg.Arc;
}
var endAngle: {
(): number;
(angle: number): D3.Svg.Arc;
(angle: () => number): D3.Svg.Arc;
(angle: (d : any) => number): D3.Svg.Arc;
(angle: (d : any, i: number) => number): D3.Svg.Arc;
}
}
@native
trait ArcDescriptor {
    var value: Any
    var data: Any
    var startAngle: Number
    var endAngle: Number
    var index: Number
}
@native
trait GraphNode {
    var id: Number
    var index: Number
    var name: String
    var px: Number
    var py: Number
    var size: Number
    var weight: Number
    var x: Number
    var y: Number
    var subindex: Number
    var startAngle: Number
    var endAngle: Number
    var value: Number
    var fixed: Boolean
    var children: Array<GraphNode>
    var _children: Array<GraphNode>
    var parent: GraphNode
    var depth: Number
}
@native
trait GraphLink {
    var source: GraphNode
    var target: GraphNode
}
@native
trait ForceLayout {
    fun invoke(): ForceLayout
    var size: {
    (): number;
    (mysize: number[]): ForceLayout;
    (accessor: (d: any, index: number) => {
    }): ForceLayout;

}
var linkDistance: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
var linkStrength: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
var friction: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
var alpha: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
var charge: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
var theta: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
var gravity: {
(): number;
(number:number): ForceLayout;
(accessor: (d: any, index: number) => number): ForceLayout;
}
var links: {
(): GraphLink[];
(arLinks: GraphLink[]): ForceLayout;

}
var nodes: {
(): GraphNode[];
(arNodes: GraphNode[]): ForceLayout;

}
fun start(): ForceLayout
fun resume(): ForceLayout
fun stop(): ForceLayout
fun tick(): ForceLayout
fun on(`type`: String, listener: () -> Unit): ForceLayout
fun drag(): ForceLayout
}
@native
trait BundleLayout {
    fun invoke(links: Array<GraphLink>): Array<GraphNode>
}
@native
trait ChordLayout {
    var matrix: {
    (): Array<number[]>;
    (matrix: Array<number[]>): ChordLayout;
}

var padding: {
(): number;
(padding: number): ChordLayout;
}

var sortGroups: {
(): number[];
(comparator: (a: number, b: number) => number): ChordLayout;
}

var sortSubgroups: {
(): number[];
(comparator: (a: number, b: number) => number): ChordLayout;
}

var sortChords: {
(): GraphLink[];
(comparator: (a: number, b: number) => number): ChordLayout;
}

fun chords(): Array<GraphLink>
fun groups(): Array<ArcDescriptor>
}
@native
trait ClusterLayout {
    var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): ClusterLayout;
}

var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): ClusterLayout;
}

fun nodes(root: GraphNode): Array<GraphNode>
fun links(nodes: Array<GraphNode>): Array<GraphLink>
var seperation: {
(): (a: GraphNode, b: GraphNode) => number;
(seperation: (a: GraphNode, b: GraphNode) => number): ClusterLayout;
}

var size: {
(): number[];
(size: number[]): ClusterLayout;
}

var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): ClusterLayout;
}

}
@native
trait HierarchyLayout {
    var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): HierarchyLayout;
}

var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): HierarchyLayout;
}

fun nodes(root: GraphNode): Array<GraphNode>
fun links(nodes: Array<GraphNode>): Array<GraphLink>
var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): HierarchyLayout;
}

fun reValue(root: GraphNode): HierarchyLayout
}
@native
trait Bin : any

[ ]  { x : number ; dx : number ; y : number ; } @native
trait HistogramLayout {
    fun invoke(values: Array<Any>, index: Number? = null): Array<Bin>
    var value: {
    (): (value: any) => any;
    (accessor: (value: any) => any): HistogramLayout
}

var range: {
(): (value: any, index: number) => number[];
(range: (value: any, index: number) => number[]): HistogramLayout;
(range: number[]): HistogramLayout;
}

var bins: {
(): (range: any[], index: number) => number[];
(bins: (range: any[], index: number) => number[]): HistogramLayout;
(bins: number): HistogramLayout;
(bins: number[]): HistogramLayout;
}

var frequency: {
(): boolean;
(frequency: boolean): HistogramLayout;
}

}
@native
trait PackLayout {
    var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): PackLayout;
}

var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): PackLayout;
}

fun nodes(root: GraphNode): Array<GraphNode>
fun links(nodes: Array<GraphNode>): Array<GraphLink>
var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): PackLayout;
}

var size: {
(): number[];
(size: number[]): PackLayout;
}

var padding: {
(): number;
(padding: number): PackLayout;
}

}
@native
trait PartitionLayout {
    var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): PackLayout;
}

var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): PackLayout;
}

fun nodes(root: GraphNode): Array<GraphNode>
fun links(nodes: Array<GraphNode>): Array<GraphLink>
var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): PackLayout;
}

var size: {
(): number[];
(size: number[]): PackLayout;
}

}
@native
trait TreeMapLayout {
    var sort: {
    (): (a: GraphNode, b: GraphNode) => number;
    (comparator: (a: GraphNode, b: GraphNode) => number): TreeMapLayout;
}

var children: {
(): (d: any, i?: number) => GraphNode[];
(children: (d: any, i?: number) => GraphNode[]): TreeMapLayout;
}

fun nodes(root: GraphNode): Array<GraphNode>
fun links(nodes: Array<GraphNode>): Array<GraphLink>
var value: {
(): (node: GraphNode) => number;
(value: (node: GraphNode) => number): TreeMapLayout;
}

var size: {
(): number[];
(size: number[]): TreeMapLayout;
}

var padding: {
(): number;
(padding: number): TreeMapLayout;
}

var round: {
(): boolean;
(round: boolean): TreeMapLayout;
}

var sticky: {
(): boolean;
(sticky: boolean): TreeMapLayout;
}

var mode: {
(): string;
(mode: string): TreeMapLayout;
}

}
}

object Color {

    @native
    trait Color {
        fun brighter(k: Number): Color
        fun darker(k: Number): Color
        fun toString(): String
    }
    @native
    trait RGBColor : Color {
        fun hsl(): HSLColor
    }
    @native
    trait HSLColor : Color {
        fun rgb(): RGBColor
    }
    @native
    trait LABColor : Color {
        fun rgb(): RGBColor
    }
    @native
    trait HCLColor : Color {
        fun rgb(): RGBColor
    }
}

object Svg {

    @native
    trait Svg {
        fun symbol(): Symbol
        fun axis(): Axis
        fun arc(): Arc
        var line: {
        (): Line;
        radial(): LineRadial;
    }

    var area: {
    (): Area;
    radial(): AreaRadial;
}

fun brush(): Brush
fun chord(): Chord
var diagonal: {
(): Diagonal;
radial(): Diagonal;
}

var symbolTypes: Array<String>
}
@native
trait Symbol {
    var `type`: (string: String) -> Symbol
    var size: (number: Number) -> Symbol
}
@native
trait Brush {
    fun invoke(selection: Selection): Unit
    var x: {
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
var y: {
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
var extent: {
/**
 * Gets the current brush extent
 */
(): any[];
/**
 * Sets the current brush extent
 */
(values: any[]): Brush;
}
fun clear(): Brush
fun empty(): Boolean
var on: {
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
@native
trait Axis {
    fun invoke(selection: Selection): Unit
    var scale: {
    (): any;
    (scale: any): Axis;
}
var orient: {
(): string;
(orientation: string): Axis;
}
var ticks: {
(): any[];
(...arguments: any[]): Axis;
}
var tickPadding: {
(): number;
(padding: number): Axis;
}
var tickValues: {
(): any[];
(values: any[]): Axis;
}
fun tickSubdivide(count: Number): Axis
fun tickSize(major: Number? = null, minor: Number? = null, end: Number? = null): Axis
fun tickFormat(formatter: (value: Any) -> String): Axis
}
@native
trait Arc {
    fun invoke(data: Any, index: Number? = null): String
    var innerRadius: {
    (): (data: any, index?: number) => number;
    (radius: number): Arc;
    (radius: () => number): Arc;
    (radius: (data: any) => number): Arc;
    (radius: (data: any, index: number) => number): Arc;
}
var outerRadius: {
(): (data: any, index?: number) => number;
(radius: number): Arc;
(radius: () => number): Arc;
(radius: (data: any) => number): Arc;
(radius: (data: any, index: number) => number): Arc;
}
var startAngle: {
(): (data: any, index?: number) => number;
(angle: number): Arc;
(angle: () => number): Arc;
(angle: (data: any) => number): Arc;
(angle: (data: any, index: number) => number): Arc;
}
var endAngle: {
(): (data: any, index?: number) => number;
(angle: number): Arc;
(angle: () => number): Arc;
(angle: (data: any) => number): Arc;
(angle: (data: any, index: number) => number): Arc;
}
fun centroid(data: Any, index: Number? = null): Array<Number>
}
@native
trait Line {
    fun invoke(data: Array<Any>, index: Number? = null): String
    var x: {
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
var y: {
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
var interpolate: {
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
var tension: {
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
var defined: {
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
@native
trait LineRadial {
    fun invoke(data: Array<Any>, index: Number? = null): String
    var x: {
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
var y: {
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
var interpolate: {
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
var tension: {
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
var defined: {
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
var radius: {
(): (d: any, i?: number) => number;
(radius: number): LineRadial;
(radius: (d: any) => number): LineRadial;
(radius: (d: any, i: number) => number): LineRadial;
}

var angle: {
(): (d: any, i?: any) => number;
(angle: number): LineRadial;
(angle: (d: any) => number): LineRadial;
(angle: (d: any, i: any) => number): LineRadial;
}

}
@native
trait Area {
    fun invoke(data: Array<Any>, index: Number? = null): String
    var x: {
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
var x0: {
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
var x1: {
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
var y: {
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
var y0: {
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
var y1: {
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
var interpolate: {
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
var tension: {
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
var defined: {
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
@native
trait AreaRadial {
    fun invoke(data: Array<Any>, index: Number? = null): String
    var x: {
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
var x0: {
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
var x1: {
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
var y: {
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
var y0: {
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
var y1: {
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
var interpolate: {
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
var tension: {
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
var defined: {
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
var radius: {
(): number;
(radius: number): AreaRadial;
(radius: () => number): AreaRadial;
(radius: (data: any) => number): AreaRadial;
(radius: (data: any, index: number) => number): AreaRadial;
}
var innerRadius: {
(): number;
(radius: number): AreaRadial;
(radius: () => number): AreaRadial;
(radius: (data: any) => number): AreaRadial;
(radius: (data: any, index: number) => number): AreaRadial;
}
var outerRadius: {
(): number;
(radius: number): AreaRadial;
(radius: () => number): AreaRadial;
(radius: (data: any) => number): AreaRadial;
(radius: (data: any, index: number) => number): AreaRadial;
}
var angle: {
(): number;
(angle: number): AreaRadial;
(angle: () => number): AreaRadial;
(angle: (data: any) => number): AreaRadial;
(angle: (data: any, index: number) => number): AreaRadial;
}
var startAngle: {
(): number;
(angle: number): AreaRadial;
(angle: () => number): AreaRadial;
(angle: (data: any) => number): AreaRadial;
(angle: (data: any, index: number) => number): AreaRadial;
}
var endAngle: {
(): number;
(angle: number): AreaRadial;
(angle: () => number): AreaRadial;
(angle: (data: any) => number): AreaRadial;
(angle: (data: any, index: number) => number): AreaRadial;
}
}
@native
trait Chord {
    fun invoke(datum: Any, index: Number? = null): String
    var radius: {
    (): number;
    (radius: number): Chord;
    (radius: () => number): Chord;
}
var startAngle: {
(): number;
(angle: number): Chord;
(angle: () => number): Chord;
}
var endAngle: {
(): number;
(angle: number): Chord;
(angle: () => number): Chord;
}
var source: {
(): any;
(angle: any): Chord;
(angle: (d: any, i?: number) => any): Chord;
}
var target: {
(): any;
(angle: any): Chord;
(angle: (d: any, i?: number) => any): Chord;
}
}
@native
trait Diagonal {
    fun invoke(datum: Any, index: Number? = null): String
    var projection: {
    (): (datum: any, index?: number) => number[];
    (proj: (datum: any) => number[]): Diagonal;
    (proj: (datum: any, index: number) => number[]): Diagonal;
}
var source: {
(): (datum: any, index?: number) => any;
(src: (datum: any) => any): Diagonal;
(src: (datum: any, index: number) => any): Diagonal;
(src: any): Diagonal;
}
var target: {
(): (datum: any, index?: number) => any;
(target: (d: any) => any): Diagonal;
(target: (d: any, i: number) => any): Diagonal;
(target: any): Diagonal;
}
}
}

object Scale {

    @native
    trait ScaleBase {
        fun linear(): LinearScale
        fun ordinal(): OrdinalScale
        fun quantize(): QuantizeScale
        fun category10(): OrdinalScale
        fun category20(): OrdinalScale
        fun category20b(): OrdinalScale
        fun category20c(): OrdinalScale
        fun identity(): IdentityScale
        fun log(): LogScale
        fun pow(): PowScale
        fun quantile(): QuantileScale
        fun sqrt(): SqrtScale
        fun theshold(): ThresholdScale
    }
    @native
    trait Scale {
        fun invoke(value: Any): Any
        var domain: {
        (values: any[]): Scale;
        (): any[];
    }
    var range: {
    (values: any[]): Scale;
    (): any[];
}
fun copy(): Scale
}
@native
trait QuantitiveScale : Scale {
    fun invoke(value: Number): Number
    fun invert(value: Number): Number
    var domain: {
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
var range: {
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
var rangeRound: (values: Array<Any>) -> QuantitiveScale
var interpolate: {
(): D3.Transition.Interpolate;
(factory: D3.Transition.Interpolate): QuantitiveScale;
}
fun clamp(clamp: Boolean): QuantitiveScale
fun nice(): QuantitiveScale
fun ticks(count: Number): Array<Any>
fun tickFormat(count: Number): (n: Number) -> String
fun copy(): QuantitiveScale
}
@native
trait LinearScale : QuantitiveScale {
    fun invoke(value: Number): Number
}
@native
trait IdentityScale : QuantitiveScale {
    fun invoke(value: Number): Number
}
@native
trait SqrtScale : QuantitiveScale {
    fun invoke(value: Number): Number
}
@native
trait PowScale : QuantitiveScale {
    fun invoke(value: Number): Number
}
@native
trait LogScale : QuantitiveScale {
    fun invoke(value: Number): Number
}
@native
trait OrdinalScale : Scale {
    fun invoke(value: Any): Any
    var domain: {
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
var range: {
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
fun rangePoints(interval: Array<Any>, padding: Number? = null): OrdinalScale
fun rangeBands(interval: Array<Any>, padding: Number? = null, outerPadding: Number? = null): OrdinalScale
fun rangeRoundBands(interval: Array<Any>, padding: Number? = null, outerPadding: Number? = null): OrdinalScale
fun rangeBand(): Number
fun rangeExtent(): Array<Any>
fun copy(): OrdinalScale
}
@native
trait QuantizeScale : Scale {
    fun invoke(value: Any): Any
    var domain: {
    (values: number[]): QuantizeScale;
    (): any[];
}
var range: {
(values: any[]): QuantizeScale;
(): any[];
}
fun copy(): QuantizeScale
}
@native
trait ThresholdScale : Scale {
    fun invoke(value: Any): Any
    var domain: {
    (values: number[]): ThresholdScale;
    (): any[];
}
var range: {
(values: any[]): ThresholdScale;
(): any[];
}
fun copy(): ThresholdScale
}
@native
trait QuantileScale : Scale {
    fun invoke(value: Any): Any
    var domain: {
    (values: number[]): QuantileScale;
    (): any[];
}
var range: {
(values: any[]): QuantileScale;
(): any[];
}
fun quantiles(): Array<Any>
fun copy(): QuantileScale
}
@native
trait TimeScale : Scale {
    fun invoke(value: Date): Number
    fun invert(value: Number): Date
    var domain: {
    (values: any[]): TimeScale;
    (): any[];
}
var range: {
(values: any[]): TimeScale;
(): any[];
}
var rangeRound: (values: Array<Any>) -> TimeScale
var interpolate: {
(): D3.Transition.Interpolate;
(factory: D3.Transition.InterpolateFactory): TimeScale;
}
fun clamp(clamp: Boolean): TimeScale
var ticks: {
(count: number): any[];
(range: Range, count: number): any[];
}
fun tickFormat(count: Number): (n: Number) -> String
fun copy(): TimeScale
}
}

object Behavior {
    @native
    trait Behavior {
        fun drag(): Drag
        fun zoom(): Zoom
    }

    @native
    trait Zoom {
        fun invoke(): Any
        var on: (`type`: String, listener: (data: Any, index: Number? = null) -> Any) -> Zoom
        var scale: {
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
    var translate: {
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
var scaleExtent: {
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
var x: {
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
var y: {
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
@native
trait Drag {
    fun invoke(): Any
    var on: (`type`: String, listener: (data: Any, index: Number? = null) -> Any) -> Drag
    var origin: {
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

    @native
    trait Geo {
        fun path(): Path
        fun circle(): Circle
        fun area(feature: Any): Number
        fun bounds(feature: Any): Array<number[]>
        fun centroid(feature: Any): Array<Number>
        fun distance(a: Array<Number>, b: Array<Number>): Number
        fun interpolate(a: Array<Number>, b: Array<Number>): (t: Number) -> Array<Number>
        fun length(feature: Any): Number
        fun projection(raw: (lambda: Any, phi: Any) -> Any): Projection
        fun projectionMutator(rawFactory: (lambda: Number, phi: Number) -> Array<Number>): Projection
        fun albers(): Projection
        fun albersUsa(): Projection
        var azimuthalEqualArea: {
        (): Projection;
        raw(): Projection;
    }

    var azimuthalEquidistant: {
    (): Projection;
    raw(): Projection;
}

var conicConformal: {
(): Projection;
raw(): Projection;
}

var conicEquidistant: {
(): Projection;
raw(): Projection;
}

var conicEqualArea: {
(): Projection;
raw(): Projection;
}

var equirectangular: {
(): Projection;
raw(): Projection;
}

var gnomonic: {
(): Projection;
raw(): Projection;
}

var mercator: {
(): Projection;
raw(): Projection;
}

var othographic: {
(): Projection;
raw(): Projection;
}

var stereographic: {
(): Projection;
raw(): Projection;
}

var transverseMercator: {
(): Projection;
raw(): Projection;
}

fun stream(`object`: GeoJSON, listener: Any): Stream
fun graticule(): Graticule
var greatArc: GreatArc
fun rotation(rotation: Array<Number>): Rotation
}
@native
trait Path {
    fun invoke(feature: Any, index: Any? = null): String
    var projection: {
    /**
     * get the geographic projection.
     */
    (): Projection;
    /**
     * set the geographic projection.
     */
    (projection: Projection): Path;
}

var context: {
/**
 * return an SVG path string invoked on the given feature.
 */
(): string;
/**
 * sets the render context and returns the path generator
 */
(context: Context): Path;
}

fun area(feature: Any): Any
fun centroid(feature: Any): Any
fun bounds(feature: Any): Any
var pointRadius: {
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
@native
trait Context {
    fun beginPath(): Any
    fun moveTo(x: Number, y: Number): Any
    fun lineTo(x: Number, y: Number): Any
    fun arc(x: Number, y: Number, radius: Number, startAngle: Number, endAngle: Number): Any
    fun closePath(): Any
}
@native
trait Circle {
    fun invoke(vararg args: Any): GeoJSON
    var origin: {
    (): number[];
    (origin: number[]): Circle;
    (origin: (...args: any[]) => number[]): Circle;
}

var angle: {
(): number;
(angle: number): Circle;
}

var precision: {
(): number;
(precision: number): Circle;
}

}
@native
trait Graticule {
    fun invoke(): GeoJSON
    fun lines(): GeoJSON
    fun outline(): GeoJSON
    var extent: {
    (): Array<number[]>;
    (extent: Array<number[]>): Graticule;
}

var minorExtent: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

var majorExtent: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

var step: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

var minorStep: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

var majorStep: {
(): Array<number[]>;
(extent: Array<number[]>): Graticule;
}

var precision: {
(): number;
(precision: number): Graticule;
}

}
@native
trait GreatArc {
    fun invoke(): GeoJSON
    fun distance(): Number
    var source: {
    (): any;
    (source: any): GreatArc;
}

var target: {
(): any;
(target: any): GreatArc;
}

var precision: {
(): number;
(precision: number): GreatArc;
}

}
@native
trait GeoJSON {
    var coordinates: Array<number[]>
    var `type`: String
}
@native
trait Projection {
    fun invoke(coordinates: Array<Number>): Array<Number>
    fun invert(point: Array<Number>): Array<Number>
    var rotate: {
    (): number[];
    (rotation: number[]): Projection;
}
var center: {
(): number[];
(location: number[]): Projection;
}
var translate: {
(): number[];
(point: number[]): Projection;
}
var scale: {
(): number;
(scale: number): Projection;
}
var clipAngle: {
(): number;
(angle: number): Projection;
}
var clipExtent: {
(): Array<number[]>;
(extent: Array<number[]>): Projection;
}
var precision: {
(): number;
(precision: number): Projection;
}
fun stream(listener: Any? = null): Stream
}
@native
trait Stream {
    fun point(x: Number, y: Number, z: Number? = null): Unit
    fun lineStart(): Unit
    fun lineEnd(): Unit
    fun polygonStart(): Unit
    fun polygonEnd(): Unit
    fun sphere(): Unit
}
@native
trait Rotation : any

[ ]  {
fun invoke(location: Array<Number>): Rotation   ; invert (location number [  ])  Rotation ; } }

object Geom {

    @native
    trait Geom {
        var voronoi: Voronoi
        fun delaunay(vertices: Array<Vertice>? = null): Array<Polygon>
        var quadtree: Quadtree
        var polygon: Polygon
        var hull: Hull
    }
    @native
    trait Vertice : number

    [ ]  {
        angle ?  : number ;
    } @native
    trait Polygon : Vertice

    [ ]  {
        fun invoke(vertices: Array<Vertice>): Polygon   ; area ( )  number ; centroid ()  number [  ] ; clip (subject Polygon)  Polygon ;
    } @native
    trait Quadtree {
        fun invoke(): Quadtree
        fun invoke(points: Array<Point>, x1: Number, y1: Number, x2: Number, y2: Number): Quadtree
        fun invoke(points: Array<Point>, width: Number, height: Number): Quadtree
        fun add(point: Point): Quadtree
        fun visit(callback: Any): Quadtree
        var x: {
        (): (d: any) => any;
        (accesor: (d: any) => any): Quadtree;

    }

    var y: {
    (): (d: any) => any;
    (accesor: (d: any) => any): Quadtree;

}

fun size(size: Array<Number>): Quadtree
}
@native
trait Point {
    var x: Number
    var y: Number
}
@native
trait Voronoi {
    fun invoke(vertices: Array<Vertice>? = null): Array<Polygon>
    var x: {
    (): (d: any) => any;
    (accesor: (d: any) => any): any;
}

var y: {
(): (d: any) => any;
(accesor: (d: any) => any): any;
}

}
@native
trait Hull {
    fun invoke(vertices: Array<Vertice>): Hull
    var x: {
    (): (d: any) => any;
    (accesor: (d: any) => any): any;
}

var y: {
(): (d: any) => any;
(accesor: (d: any) => any): any;
}

}
} }
@native
var d3: D3.Base = noImpl
*/
